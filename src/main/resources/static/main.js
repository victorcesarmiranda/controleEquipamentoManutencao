import * as axios from "/node_modules/axios/dist/axios.js";

function deletarOrdemServico (ordemServico) {
    axios
        .delete('http://localhost:8080/api/ordemservico/deletar/' + ordemServico.id)
        .then(response => ordemServico.deletada = true)
        .catch(error => {
            console.log(error)
        })
}
