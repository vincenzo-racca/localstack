package com.vincenzoracca.localstack;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

import java.nio.file.Path;

@TestConfiguration
public class LocalStackConfiguration {


    static LocalStackContainer localStack =
            new LocalStackContainer(DockerImageName.parse("localstack/localstack:4.0.3"))
                    .withFileSystemBind(Path.of("config", "init-aws.sh").toAbsolutePath().toString(),
                            "/etc/localstack/init/ready.d/init-aws.sh", BindMode.READ_ONLY)
                    .withNetworkAliases("localstack")
                    .withEnv("AWS_ACCESS_KEY_ID", "test")
                    .withEnv("AWS_SECRET_ACCESS_KEY", "test")
                    .withEnv("AWS_DEFAULT_REGION", "us-east-1");

    static {
        localStack.start();
        System.setProperty("spring.cloud.aws.endpoint", localStack.getEndpoint().toString());
    }


}
