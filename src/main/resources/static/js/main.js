let center = new kakao.maps.LatLng(37.288861484847935, 127.01424321158507);

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
  mapOption = {
    center: center, // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
  };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다

var map = new kakao.maps.Map(mapContainer, mapOption);

document.getElementById("searchBtn").addEventListener("click", ()=>{
    setTimeout(()=>{ map.relayout(); }, 1000);
    document.getElementsByClassName("modal")[0].classList.toggle('show');
})

mapContainer.addEventListener("click",()=>{
    document.getElementById("searchresult").style.display = "none";
    document.getElementById("searchbackground").style.display = "none";
})