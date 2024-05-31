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
                            result += ('<div class="info"><p>Пользователь: ' + response.result[i].userInfoResponse.firstName +
                                response.result[i].userInfoResponse.lastName +
                                '</p> <p>Комментарий: ' + response.result[i].comment +
                                '</p></div>');

                        }
                        $('#feedback').html(result);
                    } else {
                        $('#feedback').html("<p>По вашему запросу ничего не найдено</p>");
                    }

                },
                error: function () {
                }
            });
        // }
    });
});