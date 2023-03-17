function previewImages() {
  const previews = document.querySelectorAll('.pictures img'); // select all <img> elements
  const files = document.querySelectorAll('.pictures input[type=file]'); // get all uploaded files
  const buttons = document.querySelectorAll('.pictures button');
  const select = document.querySelectorAll('.pictures input[type=hidden]');

  for (let i = 0; i < files.length; i++) {
    const file = files[i].files[0]; // get the uploaded file for the current input element
    const preview = previews[i]; // get the corresponding <img> element

    const reader = new FileReader(); // create a new FileReader object

    reader.onloadend = function () {
      preview.src = reader.result; // set the src of the <img> element to the uploaded image
      select[i].value = i+1;
      preview.style.display = 'inline-block';
      buttons[i].style.display = 'inline-block';
    };

    if (file) {
      reader.readAsDataURL(file); // read the uploaded file as a URL
    } else {
      preview.src = ""; // if no file is selected, clear the <img> element
    }
  }
}

function removeImage(input,num) {
  const preview = input.previousElementSibling; // get the <img> element preceding the input element
  const file = input.nextElementSibling.querySelector('input');
  const select = document.querySelectorAll('.pictures input[type=hidden]');
  
  preview.src = ""; // clear the src attribute of the <img> element
  preview.style.display = 'none';
  input.style.display = 'none';
  file.value = ""; // clear the value attribute of the input element
  select[num-1].value="";
}