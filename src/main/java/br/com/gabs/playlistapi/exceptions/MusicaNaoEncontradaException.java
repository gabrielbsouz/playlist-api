package br.com.gabs.playlistapi.exceptions;

public class MusicaNaoEncontradaException extends RuntimeException {

    public MusicaNaoEncontradaException(String exception) {
        super(exception);
    }
}
