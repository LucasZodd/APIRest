package zodd.volt.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.FieldResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErrors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream()
                        .map(DadosErroValidacao::new)
                        .collect(Collectors.toList()));
    }

    public record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError error) {

            this(error.getField(), error.getDefaultMessage());
        }
    }

}
