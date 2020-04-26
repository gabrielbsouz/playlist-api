package br.com.gabs.playlistapi.exceptions;

public class ArtistaNaoEncontradoException extends RuntimeException {

    public ArtistaNaoEncontradoException(String exception) {
        super(exception);
    }
}
