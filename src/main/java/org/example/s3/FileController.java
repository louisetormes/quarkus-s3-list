package org.example.s3;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/files")
public class FileController {

    @Inject
    S3Service s3Service;

    private static final String BUCKET_NAME = "my-bucket-aws";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listFiles() {
        return s3Service.listFiles(BUCKET_NAME);
    }
}
