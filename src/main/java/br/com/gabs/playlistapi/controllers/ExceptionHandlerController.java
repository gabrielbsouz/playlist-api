package br.com.gabs.playlistapi.controllers;

import br.com.gabs.playlistapi.dto.Erro;
import br.com.gabs.playlistapi.dto.ParametroInvalido;
import br.com.gabs.playlistapi.exceptions.ArtistaNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        List<ParametroInvalido> invalidParameters = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String parametro = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            invalidParameters.add(new ParametroInvalido(parametro, mensagem));
        }

        Erro erro = new Erro();
        erro.setHttpCode(status.value());
        erro.setHttpMessage("Bad Request");
        erro.setDescricao("Os parâmetros informados são inválidos!");
        erro.setParametrosInvalidos(invalidParameters);

        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArtistaNaoEncontradoException.class)
    public final ResponseEntity<Erro> handleArtistaNaoEncontradoException(ArtistaNaoEncontradoException ex) {

        Erro erro = new Erro();
        erro.setHttpCode(404);
        erro.setHttpMessage("Not Found");
        erro.setDescricao(ex.getMessage());

        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
}
