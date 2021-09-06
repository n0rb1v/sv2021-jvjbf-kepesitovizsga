package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class NotBeatException extends AbstractThrowableProblem {
    public NotBeatException() {
        super(URI.create("worldrecord/notbeat"),
                "Can not beat",
                Status.BAD_REQUEST,
                "Bad request");
    }
}
