const service = new TestimonialsService();

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
  tmpl.querySelector('h4').innerText = testimonial.reviewer;
  tmpl.querySelector('p').innerText = testimonial.review;
  
  main.appendChild(tmpl);
}



document.addEventListener('DOMContentLoaded', () =>
{
  testimonials = service.loadTestimonials();
  
  displayTestimonials();

})

