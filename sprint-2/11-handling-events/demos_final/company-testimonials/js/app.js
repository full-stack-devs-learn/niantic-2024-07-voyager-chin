const service = new TestimonialsService();

let nameInput;
let nameError;
let testimonyInput;
let testimonyError;

let testimonials = [];


function displayTestimonials()
{
  if ('content' in document.createElement('template'))
  {
    testimonials.forEach((testimonial) =>
    {
      displayTesimonial(testimonial);
    });
  }
  else
  {
    console.error('Your browser does not support templates');
  }
}

function displayTesimonial(testimonial)
{
  const main = document.getElementById('main');
  const tmpl = document.getElementById('testimonial-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = testimonial.name;
  tmpl.querySelector('p').innerText = testimonial.testimonial;
  
  main.appendChild(tmpl);
}

function submitTestimonial(event)
{
  // don't let the browser perform the default submit event
  event.preventDefault();

  showErrors();

  if(nameInput.validity.valid && testimonyInput.validity.valid)
  {

    // create a new testimonial object with name and testimonial
    const name = document.getElementById("name").value;
    const testimonial = document.getElementById("testimonial").value;

    const testimony = {
      name: name,
      testimonial: testimonial
    }

    testimonials.push(testimony);
    
    displayTesimonial(testimony);

    clearForm();
  }
}

function clearForm()
{
  document.getElementById("name").value = "";
  document.getElementById("testimonial").value = "";
}



document.addEventListener('DOMContentLoaded', () =>
{
  const form = document.getElementById('form-testimonial');
  form.addEventListener('submit', submitTestimonial);

  testimonials = service.loadTestimonials();
  
  displayTestimonials();

  setupValidation();

})


function setupValidation()
{
  nameInput = document.getElementById("name");
  nameError = document.getElementById("nameError");
  testimonyInput = document.getElementById("testimonial");
  testimonyError = document.getElementById("testimonyError");
}

function showErrors()
{

  if(!nameInput.validity.valid)
  {
    nameError.textContent = "Name is required";
    nameInput.classList.add("error")
  }
  else
  {
    nameError.textContent = "";
    nameInput.classList.remove("error")
  }

  if(!testimonyInput.validity.valid)
  {
    testimonyError.textContent = "Your testimony is required";
    testimonyInput.classList.add("error")
  }
  else
  {
    testimonyError.textContent = "";
    testimonyInput.classList.remove("error")
  }
}

