const showLoadingButton = document.getElementById('showLoadingButton');



showLoadingButton.addEventListener('click', () => {
  const loadingOverlay = document.createElement('div');
  loadingOverlay.classList.add('loading-overlay');

  const loadingSpinner = document.createElement('div');
  loadingSpinner.classList.add('loading-spinner');

  loadingOverlay.appendChild(loadingSpinner);
  document.body.appendChild(loadingOverlay);

  // Simula um atraso de 2 segundos (pode ser removido em um ambiente real)
  setTimeout(() => {
    loadingOverlay.remove(); 

    window.location.href = "http://127.0.0.1:5500/EnxameTech_2.0/dashbord-home.html"; // Substitua com a URL desejada
}, 2000); // Redireciona após 2 segundos (tempo igual ao tempo do seu setTimeout)
}); 