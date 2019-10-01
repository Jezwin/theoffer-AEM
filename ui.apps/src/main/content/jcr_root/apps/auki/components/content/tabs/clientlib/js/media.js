function myFunction(x) {
  if (x.matches) { // If media query matches
    document.getElementsByClassName("responsivegrid").classList.add('aem-GridColumn--tablet--12');
    document.getElementsByClassName("image").classList.remove('aem-GridColumn--tablet--5');
  }
}

var x = window.matchMedia("(max-width: 768px)")
myFunction(x) // Call listener function at run time
x.addListener(myFunction) // Attach listener function on state changes