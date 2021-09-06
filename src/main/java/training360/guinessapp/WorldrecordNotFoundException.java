package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class WorldrecordNotFoundException extends AbstractThrowableProblem {
    public WorldrecordNotFoundException() {
        super(URI.create("worldrecord/not-found"),
                "World record not found",
                Status.NOT_FOUND,
                "Not found");
    }
}
