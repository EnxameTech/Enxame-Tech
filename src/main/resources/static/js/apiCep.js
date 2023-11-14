const addressForm = document.querySelector("#form");
const cepInput = document.querySelector("#cep");
const ruaInput = document.querySelector("#rua");
const cidadeInput = document.querySelector("#cidade");
const bairroInput = document.querySelector("#bairro");
const ufInput = document.querySelector("#uf");

cepInput.addEventListener("input", async (e) => {
  const inputValue = e.target.value.replace(/\D/g, ''); // Remover caracteres não numéricos
  if (inputValue.length === 8) {
    try {
      const addressData = await getAdress(inputValue);
      updateAddressFields(addressData);
    } catch (error) {
      // console.error(error);
    }
  }
});

const getAdress = async (cep) => {
  const apiURL = `https://viacep.com.br/ws/${cep}/json/`;
  const response = await fetch(apiURL);

  if (!response.ok) {
    throw new Error(`Erro ao obter dados do CEP. Status: ${response.status}`);
  }

  const data = await response.json();
  return data;
};

const updateAddressFields = (addressData) => {
  ruaInput.value = addressData.logradouro || '';
  bairroInput.value = addressData.bairro || '';
  cidadeInput.value = addressData.localidade || '';
  ufInput.value = addressData.uf || '';
};