import React, { useState, useEffect } from "react";
import axios from "../services/api";
import Button from "../components/Button";

const FilaPage = () => {
  const [mapa, setMapa] = useState("");
  const [jogador, setJogador] = useState("");
  const [filaStatus, setFilaStatus] = useState(0);
  const [servidorIP, setServidorIP] = useState("");

  const entrarNaFila = async () => {
    try {
      const response = await axios.post("/fila/entrar", {
        jogador,
        mapa
      });
      setServidorIP(response.data.includes("IP") ? response.data.split("!")[1].trim() : "");
      alert(response.data);
    } catch (error) {
      console.error("Erro ao entrar na fila", error);
    }
  };

  useEffect(() => {
    const interval = setInterval(() => {
      axios.get(`/fila/status/${mapa}`)
        .then(response => {
          setFilaStatus(response.data);
        })
        .catch(error => console.error(error));
    }, 5000);

    return () => clearInterval(interval);
  }, [mapa]);

  return (
    <div className="FilaPage">
      <h1>Fila de Jogo</h1>
      <input type="text" placeholder="Digite seu nome" value={jogador} onChange={(e) => setJogador(e.target.value)} />
      <select value={mapa} onChange={(e) => setMapa(e.target.value)}>
        <option value="">Escolha um mapa</option>
        <option value="Dust2">Dust2</option>
        <option value="Mirage">Mirage</option>
        <option value="Inferno">Inferno</option>
      </select>
      <Button onClick={entrarNaFila} disabled={!jogador || !mapa}>Entrar na Fila</Button>
      <p>Status da fila: {filaStatus} / 10 jogadores</p>
      {servidorIP && <p>Servidor pronto! IP: {servidorIP}</p>}
    </div>
  );
};

export default FilaPage;
