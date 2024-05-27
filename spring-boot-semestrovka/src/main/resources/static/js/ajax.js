$(document).ready(function () {
    $("#query").on("input", function () {
        var query = $("#query").val();
            $.ajax({
                url: "../walkers/search",
                method: "POST",
                data: {query: query},
                dataType: 'json',
                success: function (response) {
                    if (response.result.length > 0) {
                        var result = "";
                        for (let i = 0; i < response.result.length; i++) {
                            result += ('<p>Пользователь: ' + response.result[i].userInfoResponse.firstName +
                                response.result[i].userInfoResponse.lastName +
                                '</p> <p>Комментарий: ' + response.result[i].comment +
                                '</p> <button type="submit">Написать</button>');

                        }
                        $('#feedback').html(result);
                    } else {
                        $('#feedback').html("Не найдено");
                    }

                },
                error: function () {
                }
            });
        // }
    });
});