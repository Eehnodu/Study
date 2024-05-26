function margin(){
    document.getElementById('change').innerHTML = "<div id='red'></div>\
    <div id='green' style='position: relative; left: 100px;'></div>\
    <div id='blue' style='position: relative; left: 200px;'></div>\
    <div id='gray' style='position: relative; left: 300px;'></div>"
}

function border(){
    document.getElementById('change').innerHTML =
    "<div id='red' style ='border-top-right-radius: 50px; border-bottom-left-radius: 50px;'></div>\
    <div id='green' style='position: relative; left: 100px; border-top-right-radius: 50px; border-bottom-left-radius: 50px;'></div>\
    <div id='blue' style='position: relative; left: 200px; border-top-right-radius: 50px; border-bottom-left-radius: 50px;'></div>\
    <div id='gray' style='position: relative; left: 300px; border-top-right-radius: 50px; border-bottom-left-radius: 50px;'></div>"
}