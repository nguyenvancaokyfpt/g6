
    <body>
        <div class="content d-flex flex-column flex-column-fluid" id="kt_content">
            <div class="post d-flex flex-column-fluid" id="kt_post" style="justify-content: center;">
                <div class="apexcharts-canvas apexchartsriz8dtt5 apexcharts-theme-light">
                    <canvas id="chartConfirm" style="width:100%;max-width:700px;margin-top: 100px;"></canvas>
                    <canvas id="chartRecovered" style="width:100%;max-width:700px;margin-top: 100px;"></canvas>
                    <canvas id="chartTested" style="width:100%;max-width:700px;margin-top: 100px;"></canvas>
                </div>
            </div>
        </div>

        <script>
            const chartConfirm = [];
            const chartRecovered = [];
            const chartTested = [];
            function doGetJSON() {
                // A URL returns JSON data.
                var url = "https://data.covid19india.org/v4/min/timeseries.min.json";
                // Call fetch(url) with default options.
                // It returns a Promise object:
                var aPromise = fetch(url);
                // Work with Promise object:
                aPromise.then(function (response) {
                    if (!response.ok) {
                        throw new Error("HTTP error, status = " + response.status);
                    }
                    // Get JSON Promise from response object:
                    var myJSON_promise = response.json();
                    // Work with Promise object:
                    myJSON_promise.then(function (myJSON) {
                        var array = Object.entries(myJSON.AN.dates);
                        console.log(array);
                        for (var i = 0; i < array.length; i++) {
                            var a = array[i];
                            chartConfirm.push({
                                x: a[0],
                                y: a[1].delta ? a[1].delta.confirmed : 0
                            });
                            chartRecovered.push({
                                x: a[0],
                                y: a[1].delta && a[1].delta.recovered ? a[1].delta.recovered : 0
                            });
                            chartTested.push({
                                x: a[0],
                                y: a[1].delta && a[1].delta.tested ? a[1].delta.tested : 0
                            });
                        }
                        new Chart("chartConfirm", {
                            type: "scatter",
                            data: {
                                datasets: [{
                                        pointRadius: 4,
                                        pointBackgroundColor: "rgb(0,0,255)",
                                        data: chartConfirm
                                    }]
                            },
                            options: {
                                title: {
                                    display: true,
                                    text: "Confirmed",
                                    fontSize: 16
                                },
                                legend: {display: false},
                                scales: {
                                    xAxes: [{
                                            type: 'time',
                                            time: {
                                                displayFormats: {
                                                    quarter: 'MMM YYYY'
                                                }
                                            }
                                        }]
                                }
                            }
                        });
                        new Chart("chartRecovered", {
                            type: "scatter",
                            data: {
                                datasets: [{
                                        pointRadius: 4,
                                        pointBackgroundColor: "rgb(255, 0, 0)",
                                        data: chartRecovered
                                    }]
                            },
                            options: {
                                title: {
                                    display: true,
                                    text: "Recover",
                                    fontSize: 16
                                },
                                legend: {
                                    display: false},
                                scales: {
                                    xAxes: [{
                                            type: 'time',
                                            time: {
                                                displayFormats: {
                                                    quarter: 'MMM YYYY'
                                                }
                                            }
                                        }]
                                }
                            }
                        });
                        new Chart("chartTested", {
                            type: "scatter",
                            data: {
                                datasets: [{
                                        pointRadius: 4,
                                        pointBackgroundColor: "rgb(255, 255, 0)",
                                        data: chartTested
                                    }]
                            },
                            options: {
                                title: {
                                    display: true,
                                    text: "Tested",
                                    fontSize: 16
                                },
                                legend: {
                                    display: false},
                                scales: {
                                    xAxes: [{
                                            type: 'time',
                                            time: {
                                                displayFormats: {
                                                    quarter: 'MMM YYYY'
                                                }
                                            }
                                        }]
                                }
                            }
                        });
                    })
                })
                        .catch(function (error) {
                            console.log("Noooooo! Something error:");
                            console.log(error);
                        });
            }

            window.onload = function ()
            {
                doGetJSON();
            };

        </script>

    </body>