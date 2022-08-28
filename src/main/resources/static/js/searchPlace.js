tplace = document.getElementById("place");
taddress = document.getElementById("address");
tx = document.getElementById("x");
ty = document.getElementById("y");

searchbar = document.getElementById("searchbar");
searchtext = document.getElementById("searchtext");
searchresult = document.getElementById("searchresult");
sbackground = document.getElementById("searchbackground");

modal = document.getElementsByClassName("modal");

let prevMarker;

function submitHandler(event) {
  sbackground.style.display = "block";
  searchresult.style.display = "block";
  event.preventDefault();
  search(searchtext.value);
  searchtext.value = '';
}

async function search(text) {
  let url = 'https://dapi.kakao.com/v2/local/search/keyword.json?query=' + encodeURIComponent(text);
  let options = {
    method: 'GET',
    headers: {
      "Authorization": "KakaoAK edd84ee3d8c9626a92ab5fbd2ab93622"
    }
  }

  response = await fetch(url, options);
  json = await response.json();

  if (response.ok == false) {
    alert("네트워크 오류입니다.");
    return;
  }
  if (json.meta.total_count == 0) {
    alert("검색결과가 없습니다.");
    return;
  }

  display(json);
}

function display(results) {
  markers = [];
  bounds = new kakao.maps.LatLngBounds();

  delList();

  if (results.meta.total_count == 0) {
    alert("검색결과가 없습니다.");
    return;
  }

  for (idx in results.documents) {
    data = results.documents[idx];
    placePosition = new kakao.maps.LatLng(data.y, data.x);

    bounds.extend(new kakao.maps.LatLng(data.y, data.x));

    searchresult.appendChild(createList(idx + 1, data));
    searchresult.appendChild(document.createElement("br"));

  }

  map.setBounds(bounds);
}

function createList(idx, data) {
  let d = document.createElement("div");
  let li1 = document.createElement("li");
  let li2 = document.createElement("li");

  d.id = "searchlist" + idx;
  li1.innerText = data.place_name;
  li2.innerText = data.address_name;
  li2.style = "font-size:12px;color: rgb(134, 134, 147);";

  d.appendChild(li1);
  d.appendChild(li2);

  d.addEventListener("mouseover", function() {
    d.style = "background-color:#ecedd8";
  });
  d.addEventListener("mouseout", function() {
    d.style = "background-color:white";
  });
  d.addEventListener("click", function() {
    if (prevMarker)
      prevMarker.setMap(null);

    placePosition = new kakao.maps.LatLng(data.y, data.x);
    marker = new kakao.maps.Marker({
      position: placePosition,
      clickable: true
    });
    marker.setMap(map);
    prevMarker = marker;
    map.setCenter(placePosition);
    map.setLevel(3);

    kakao.maps.event.addListener(marker, 'click', function() {
      marker.setMap(null);
    });
  })
  d.addEventListener("dblclick", function() {
    tplace.value = data.place_name;
    taddress.value = data.address_name;
    tx.value = data.x;
    ty.value = data.y;

    modal[0].classList.toggle('show');
  })

  return d;
}

function delList() {
  while (searchresult.firstChild) {
    searchresult.removeChild(searchresult.firstChild);
  }
}

searchbar.addEventListener("submit", submitHandler);