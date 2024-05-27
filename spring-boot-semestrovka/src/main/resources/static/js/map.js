ymaps.ready(init);
function init() {
    var myMap = new ymaps.Map("map", {
        center: [55.7887, 49.1221],
        zoom: 10
    });

    var addressList = document.getElementById('addressList');
    for (var i = 0; i < addressList.children.length; i++) {
        var lat = parseFloat(addressList.children[i].getAttribute('data-lat'));
        var lon = parseFloat(addressList.children[i].getAttribute('data-lon'));
        addPlacemark(lat, lon);
    }

    // Обработчик событий для приближения карты к метке
    addressList.addEventListener('click', function(event) {
        var target = event.target;
        if (target.tagName === 'LI') {
            var lat = parseFloat(target.getAttribute('data-lat'));
            var lon = parseFloat(target.getAttribute('data-lon'));
            myMap.setCenter([lat, lon]);
            myMap.setZoom(15); // Установите желаемый уровень зума
        }
    });

    function addPlacemark(lat, lon) {
        // var coords = [lat, lon];
        // var myPlacemark = new ymaps.Placemark(coords, {
        //     hintContent: 'Здесь может быть ваше название'
        // });
        // myMap.geoObjects.add(myPlacemark);

        var coords = [lat, lon];
        var myPlacemark = new ymaps.Placemark(coords, {
            hintContent: 'Здесь может быть ваше название'
        });

        // Добавляем обработчик события добавления метки на карту
        myMap.events.add('add', function (event) {
            // Получаем объект метки, который был добавлен
            var placemark = event.get('target');

            // Получаем координаты метки
            var lat = placemark.geometry.getCoordinates()[0];
            var lon = placemark.geometry.getCoordinates()[1];

            // Выполняем обратное геокодирование для получения адреса
            ymaps.geocode([lat, lon]).then(function (res) {
                var firstGeoObject = res.geoObjects.get(0);
                var address = firstGeoObject.getAddressLine();

                // Находим элемент списка, соответствующий данной метке
                var li = document.querySelector('li[data-lat="' + lat + '"][data-lon="' + lon + '"]');

                // Меняем текст элемента списка на адрес
                li.textContent = address;
            });
        });

        myMap.geoObjects.add(myPlacemark);
    }



}
