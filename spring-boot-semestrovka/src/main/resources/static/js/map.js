ymaps.ready(init);
function init() {
    var myMap = new ymaps.Map("map", {
        center: [55.7887, 49.1221],
        zoom: 10
    });
    // var myPlacemark = new ymaps.Placemark([55.76, 37.64], {
    //     hintContent: 'Содержимое всплывающей подсказки',
    //     balloonContent: 'Содержимое балуна'
    // });
    // myMap.geoObjects.add(myPlacemark);

    // var placemarks = [
    //     [55.75, 37.57], // Координаты метки 1
    //     [55.751, 37.60] // Координаты метки 2
    //     // Добавьте здесь данные для дополнительных меток
    // ];
    //
    // // Создаем и добавляем метки на карту
    // placemarks.forEach(function (coords) {
    //     ymaps.geocode(coords).then(function (res) {
    //         var firstGeoObject = res.geoObjects.get(0);
    //         var address = firstGeoObject.getAddressLine(); // Адрес метки
    //         var placemark = new ymaps.Placemark(coords, {
    //             hintContent: address // Адрес в подсказке при наведении
    //         }, {
    //             preset: 'islands#blueStretchyIcon' // Предустановленный стиль иконки метки
    //         });
    //         myMap.geoObjects.add(placemark);
    //     });
    // });

}
