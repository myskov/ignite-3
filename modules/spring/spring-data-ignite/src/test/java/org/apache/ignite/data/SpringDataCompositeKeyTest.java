package org.apache.ignite.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.ignite.data.repository.PersonId;
import org.apache.ignite.data.repository.PersonWithCompositeKey;
import org.apache.ignite.data.repository.PersonWithCompositeKeyRepository;
import org.apache.ignite.internal.Cluster;
import org.apache.ignite.internal.ClusterConfiguration;
import org.apache.ignite.internal.testframework.BaseIgniteAbstractTest;
import org.apache.ignite.internal.testframework.WorkDirectory;
import org.apache.ignite.internal.testframework.WorkDirectoryExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApplication.class)
@ExtendWith(WorkDirectoryExtension.class)
public class SpringDataCompositeKeyTest extends BaseIgniteAbstractTest {

    @WorkDirectory
    private static Path workDir;
    private static Cluster cluster;

    @Autowired
    PersonWithCompositeKeyRepository repository;

    @BeforeAll
    static void setUp(TestInfo testInfo) {
        ClusterConfiguration clusterConfiguration = ClusterConfiguration.builder(testInfo, workDir).build();

        cluster = new Cluster(clusterConfiguration);
        cluster.startAndInit(1);

        cluster.aliveNode().sql().execute(null, "CREATE TABLE IF NOT EXISTS PERSON_WITH_COMPOSITE_KEY ("
                + "    id INT,"
                + "    name VARCHAR,"
                + "    age INT,"
                + "    Primary key(id, name)"
                + ");");
    }

    @BeforeEach
    void setupEach() {
        repository.deleteAll();
    }

    @Test
    public void savesAnEntity() {
        PersonId personId = new PersonId(1L, "John");
        PersonWithCompositeKey person1 = new PersonWithCompositeKey(personId, 30L);
        repository.save(person1);

        assertThat(repository.count()).isEqualTo(1);
    }

}
