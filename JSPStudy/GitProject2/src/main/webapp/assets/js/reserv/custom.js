
(function ($) {

  "use strict";

  // MENU


  // CUSTOM LINK


  $('.owl-carousel').owlCarousel({
    center: true,
    loop: true,
    margin: 30,
    autoplay: true,
    responsiveClass: true,
    responsive: {
      0: {
        items: 1,
      },
      767: {
        items: 2,
      },
      1200: {
        items: 4,
      }
    }
  });

})(window.jQuery);


function resizeButton() {
  var button = document.querySelector('.btn');
  var text = button.textContent;
  var textLength = text.length;
  var fontSize = parseFloat(window.getComputedStyle(button).fontSize); // Get font size in pixels

  // Calculate the width of the text based on the number of characters and font size
  var textWidth = textLength * fontSize * 0.5; // Adjust multiplier as needed

  // Set the calculated width as the width of the button
  button.style.width = textWidth + 'px';
}

