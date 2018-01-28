package com.mesosphere.sdk.nifi.scheduler;

import java.util.HashMap;
import java.util.Map;

// import java.util.ArrayList;
// import java.util.Collection;

// import org.apache.mesos.Protos;
import org.junit.Test;

// import com.mesosphere.sdk.testing.Expect;
// import com.mesosphere.sdk.testing.Send;
import com.mesosphere.sdk.testing.ServiceTestRunner;
// import com.mesosphere.sdk.testing.SimulationTick;

public class ServiceTest {

    @Test
    public void testSpec() throws Exception {
        // Collection<SimulationTick> ticks = new ArrayList<>();

        // ticks.add(Send.register());

        // ticks.add(Expect.reconciledImplicitly());

        // // "node" task fails to launch on first attempt, without having entered RUNNING.
        // ticks.add(Send.offerBuilder("nifi").build());
        // ticks.add(Expect.launchedTasks("nifi-0-node"));
        // ticks.add(Send.taskStatus("nifi-0-node", Protos.TaskState.TASK_ERROR).build());

        // // Because the task has now been "pinned", a different offer which would fit the task is declined:
        // ticks.add(Send.offerBuilder("nifi").build());
        // ticks.add(Expect.declinedLastOffer());

        // // It accepts the offer with the correct resource ids:
        // ticks.add(Send.offerBuilder("nifi").setPodIndexToReoffer(0).build());
        // ticks.add(Expect.launchedTasks("nifi-0-node"));
        // ticks.add(Send.taskStatus("nifi-0-node", Protos.TaskState.TASK_RUNNING).build());

        // // With the pod now running, the scheduler now ignores the same resources if they're reoffered:
        // ticks.add(Send.offerBuilder("nifi").setPodIndexToReoffer(0).build());
        // ticks.add(Expect.declinedLastOffer());

        // ticks.add(Expect.allPlansComplete());

        // Map<String, String> schedulerEnv = new HashMap<>();
        //     schedulerEnv.put("CONFIG_TEMPLATE_PATH", "");

        new ServiceTestRunner()
            // .setSchedulerEnv(schedulerEnv)
            // .setPodEnv("nifi", getDefaultPodEnv())
            // .run(ticks);
            .run();
    }

    private static Map<String, String> getDefaultPodEnv() {
        Map<String, String> map = new HashMap<>();
            // map.put("NODE_COUNT", "3");
            // map.put("PORT_WEB", "8080");
            // map.put("PORT_PROTOCOL", "9090");
            return map;
    }

    private static Map<String, String> getDefaultSchedulerEnv() {
        Map<String, String> map = new HashMap<>();
            map.put("FRAMEWORK_NAME", "nifi");
            map.put("FRAMEWORK_PRINCIPAL", "nifi-principal");
            map.put("FRAMEWORK_USER", "nobody");
            map.put("FRAMEWORK_ZOOEKEEPER", "zk-1.zk:2181,zk-2.zk:2181,zk-3.zk:2181,zk-4.zk:2181,zk-5.zk:2181");

            map.put("DEPLOY_STRATEGY", "parallel");
            map.put("UPDATE_STRATEGY", "serial");
            map.put("REPLACE_STRATEGY", "serial");

            map.put("JAVA_URI", "");
            map.put("LIBMESOS_URI", "");
            map.put("BOOTSTRAP_URI", "");
            map.put("EXECUTOR_URI", "");
            map.put("NIFI_URI", "");

            map.put("CONFIG_TEMPLATE_PATH", "");

            map.put("NODE_COUNT", "3");
            map.put("NODE_CPUS", "1");
            map.put("NODE_MEM", "1024");
            map.put("NODE_PORT", "0");

            map.put("NODE_VIP_PREFIX", "nifi");
            map.put("NODE_VIP_PORT", "8080");

            map.put("NODE_RLIMIT_NOFILE_SOFT", "50000");
            map.put("NODE_RLIMIT_NOFILE_HARD", "50000");
            map.put("NODE_RLIMIT_NPROC_SOFT", "10000");
            map.put("NODE_RLIMIT_NPROC_HARD", "10000");

            map.put("NODE_PLACEMENT", "hostname:UNIQUE");

            map.put("NODE_CONTENT_REPOSITORY_DISK_PATH", "content_repository");
            map.put("NODE_CONTENT_REPOSITORY_DISK_TYPE", "ROOT");
            map.put("NODE_CONTENT_REPOSITORY_DISK_SIZE", "1000");

            map.put("NODE_DATABASE_REPOSITORY_DISK_PATH", "database_repository");
            map.put("NODE_DATABASE_REPOSITORY_DISK_TYPE", "ROOT");
            map.put("NODE_DATABASE_REPOSITORY_DISK_SIZE", "1000");

            map.put("NODE_FLOWFILE_REPOSITORY_DISK_PATH", "flowfile_repository");
            map.put("NODE_FLOWFILE_REPOSITORY_DISK_TYPE", "ROOT");
            map.put("NODE_FLOWFILE_REPOSITORY_DISK_SIZE", "1000");

            map.put("NODE_PROVENANCE_REPOSITORY_DISK_PATH", "provenance_repository");
            map.put("NODE_PROVENANCE_REPOSITORY_DISK_TYPE", "ROOT");
            map.put("NODE_PROVENANCE_REPOSITORY_DISK_SIZE", "1000");

            map.put("NIFI_VERSION", "1.5.0");

            map.put("NIFI_LDAP_AUTHENTICATION_STRATEGY", "START_TLS");
            map.put("NIFI_LDAP_MANAGER_DN", "user@example.com");
            map.put("NIFI_LDAP_MANAGER_PASSWORD", "password");
            map.put("NIFI_LDAP_TLS_KEYSTORE_PATH", "./conf/keystore.jks");
            map.put("NIFI_LDAP_TLS_KEYSTORE_PASSWORD", "keystore-password-changeit");
            map.put("NIFI_LDAP_TLS_KEYSTORE_TYPE", "PKCS12");
            map.put("NIFI_LDAP_TLS_TRUSTSTORE_PATH", "./conf/truststore.jks");
            map.put("NIFI_LDAP_TLS_TRUSTSTORE_PASSWORD", "truststore-password-changeit");
            map.put("NIFI_LDAP_TLS_TRUSTSTORE_TYPE", "PKCS12");
            map.put("NIFI_LDAP_TLS_CLIENT_AUTH", "REQUIRED");
            map.put("NIFI_LDAP_TLS_PROTOCOL", "TLSv1.2");
            map.put("NIFI_LDAP_TLS_SHUTDOWN_GRACEFULLY", "false");
            map.put("NIFI_LDAP_REFERRAL_STRATEGY", "FOLLOW");
            map.put("NIFI_LDAP_CONNECT_TIMEOUT", "10 secs");
            map.put("NIFI_LDAP_READ_TIMEOUT", "10 secs");
            map.put("NIFI_LDAP_URL", "ldap://<hostname>:<port>");
            map.put("NIFI_LDAP_USER_SEARCH_BASE", "CN=Users,DC=example,DC=com");
            map.put("NIFI_LDAP_USER_SEARCH_FILTER", "sAMAccountName={0}");
            map.put("NIFI_LDAP_IDENTITY_STRATEGY", "USE_DN");
            map.put("NIFI_LDAP_AUTHENTICATION_EXPIRATION", "12 hours");

            map.put("NIFI_FLOW_CONFIGURATION_FILE", "./conf/flow.xml.gz");
            map.put("NIFI_FLOW_CONFIGURATION_ARCHIVE_ENABLED", "true");
            map.put("NIFI_FLOW_CONFIGURATION_ARCHIVE_DIR", "./conf/archive/");
            map.put("NIFI_FLOW_CONFIGURATION_ARCHIVE_MAX_TIME", "30 days");
            map.put("NIFI_FLOW_CONFIGURATION_ARCHIVE_MAX_STORAGE", "500 MB");
            map.put("NIFI_FLOW_CONFIGURATION_ARCHIVE_MAX_COUNT", "");
            map.put("NIFI_FLOWCONTROLLER_AUTORESUMESTATE", "true");
            map.put("NIFI_FLOWCONTROLLER_GRACEFUL_SHUTDOWN_PERIOD", "10 secs");
            map.put("NIFI_FLOWSERVICE_WRITEDELAY_INTERVAL", "500 millis");

            map.put("NIFI_ADMINISTRATIVE_YIELD_DURATION", "30 secs");
            map.put("NIFI_BORED_YIELD_DURATION", "10 millis");

            map.put("NIFI_AUTHORIZER_CONFIGURATION_FILE", "./conf/authorizers.xml");
            map.put("NIFI_LOGIN_IDENTITY_PROVIDER_CONFIGURATION_FILE", "./conf/login-identity-providers.xml");

            map.put("NIFI_TEMPLATES_DIRECTORY", "./conf/templates");
            map.put("NIFI_UI_BANNER_TEXT", "");
            map.put("NIFI_UI_AUTOREFRESH_INTERVAL", "30 secs");
            map.put("NIFI_NAR_LIBRARY_DIRECTORY", "./lib");
            map.put("NIFI_NAR_WORKING_DIRECTORY", "./work/nar/");
            map.put("NIFI_DOCUMENTATION_WORKING_DIRECTORY", "./work/docs/components");
            map.put("NIFI_PROCESSOR_SCHEDULING_TIMEOUT", "1 mins");

            map.put("NIFI_STATE_MANAGEMENT_CONFIGURATION_FILE", "./conf/state-management.xml");
            map.put("NIFI_STATE_MANAGEMENT_PROVIDER_LOCAL", "local-provider");
            map.put("NIFI_STATE_MANAGEMENT_PROVIDER_CLUSTER", "zk-provider");
            map.put("NIFI_STATE_MANAGEMENT_EMBEDDED_ZOOKEEPER_START", "false");
            map.put("NIFI_STATE_MANAGEMENT_EMBEDDED_ZOOKEEPER_PROPERTIES", "./conf/zookeeper.properties");

            map.put("NIFI_DATABASE_DIRECTORY", "./database_repository");
            map.put("NIFI_H2_URL_APPEND", ";LOCK_TIMEOUT=25000;WRITE_DELAY=0;AUTO_SERVER=FALSE");

            map.put("NIFI_FLOWFILE_REPOSITORY_IMPLEMENTATION", "org.apache.nifi.controller.repository.WriteAheadFlowFileRepository");
            map.put("NIFI_FLOWFILE_REPOSITORY_DIRECTORY", "./flowfile_repository");
            map.put("NIFI_FLOWFILE_REPOSITORY_PARTITIONS", "256");
            map.put("NIFI_FLOWFILE_REPOSITORY_CHECKPOINT_INTERVAL", "2 mins");
            map.put("NIFI_FLOWFILE_REPOSITORY_ALWAYS_SYNC", "false");

            map.put("NIFI_SWAP_MANAGER_IMPLEMENTATION", "org.apache.nifi.controller.FileSystemSwapManager");
            map.put("NIFI_QUEUE_SWAP_THRESHOLD", "20000");
            map.put("NIFI_SWAP_IN_PERIOD", "5 secs");
            map.put("NIFI_SWAP_IN_THREADS", "1");
            map.put("NIFI_SWAP_OUT_PERIOD", "5 secs");
            map.put("NIFI_SWAP_OUT_THREADS", "4");

            map.put("NIFI_CONTENT_REPOSITORY_IMPLEMENTATION", "org.apache.nifi.controller.repository.FileSystemRepository");
            map.put("NIFI_CONTENT_CLAIM_MAX_APPENDABLE_SIZE", "10 MB");
            map.put("NIFI_CONTENT_CLAIM_MAX_FLOW_FILES", "100");
            map.put("NIFI_CONTENT_REPOSITORY_DIRECTORY_DEFAULT", "./content_repository");
            map.put("NIFI_CONTENT_REPOSITORY_ARCHIVE_MAX_RETENTION_PERIOD", "12 hours");
            map.put("NIFI_CONTENT_REPOSITORY_ARCHIVE_MAX_USAGE_PERCENTAGE", "50%");
            map.put("NIFI_CONTENT_REPOSITORY_ARCHIVE_ENABLED", "true");
            map.put("NIFI_CONTENT_REPOSITORY_ALWAYS_SYNC", "false");
            map.put("NIFI_CONTENT_VIEWER_URL", "/nifi-content-viewer/");

            map.put("NIFI_VOLATILE_CONTENT_REPOSITORY_MAX_SIZE", "100 MB");
            map.put("NIFI_VOLATILE_CONTENT_REPOSITORY_BLOCK_SIZE", "32 KB");

            map.put("NIFI_PROVENANCE_REPOSITORY_IMPLEMENTATION", "org.apache.nifi.provenance.PersistentProvenanceRepository");

            map.put("NIFI_PROVENANCE_REPOSITORY_DIRECTORY_DEFAULT", "./provenance_repository");
            map.put("NIFI_PROVENANCE_REPOSITORY_MAX_STORAGE_TIME", "24 hours");
            map.put("NIFI_PROVENANCE_REPOSITORY_MAX_STORAGE_SIZE", "1 GB");
            map.put("NIFI_PROVENANCE_REPOSITORY_ROLLOVER_TIME", "30 secs");
            map.put("NIFI_PROVENANCE_REPOSITORY_ROLLOVER_SIZE", "100 MB");
            map.put("NIFI_PROVENANCE_REPOSITORY_QUERY_THREADS", "2");
            map.put("NIFI_PROVENANCE_REPOSITORY_INDEX_THREADS", "2");
            map.put("NIFI_PROVENANCE_REPOSITORY_COMPRESS_ON_ROLLOVER", "true");
            map.put("NIFI_PROVENANCE_REPOSITORY_ALWAYS_SYNC", "false");
            map.put("NIFI_PROVENANCE_REPOSITORY_JOURNAL_COUNT", "16");
            map.put("NIFI_PROVENANCE_REPOSITORY_INDEXED_FIELDS", "EventType, FlowFileUUID, Filename, ProcessorID, Relationship");
            map.put("NIFI_PROVENANCE_REPOSITORY_INDEXED_ATTRIBUTES", "");
            map.put("NIFI_PROVENANCE_REPOSITORY_INDEX_SHARD_SIZE", "500 MB");
            map.put("NIFI_PROVENANCE_REPOSITORY_MAX_ATTRIBUTE_LENGTH", "65536");

            map.put("NIFI_PROVENANCE_REPOSITORY_BUFFER_SIZE", "100000");

            map.put("NIFI_PROVENANCE_REPOSITORY_CONCURRENT_MERGE_THREADS", "2");
            map.put("NIFI_PROVENANCE_REPOSITORY_WARM_CACHE_FREQUENCY", "");

            map.put("NIFI_PROVENANCE_REPOSITORY_DEBUG_FREQUENCY", "1_000_000");

            map.put("NIFI_PROVENANCE_REPOSITORY_ENCRYPTION_KEY_PROVIDER_IMPLEMENTATION", "");
            map.put("NIFI_PROVENANCE_REPOSITORY_ENCRYPTION_KEY_PROVIDER_LOCATION", "");
            map.put("NIFI_PROVENANCE_REPOSITORY_ENCRYPTION_KEY_ID", "");
            map.put("NIFI_PROVENANCE_REPOSITORY_ENCRYPTION_KEY", "");

            map.put("NIFI_COMPONENTS_STATUS_REPOSITORY_IMPLEMENTATION", "org.apache.nifi.controller.status.history.VolatileComponentStatusRepository");
            map.put("NIFI_COMPONENTS_STATUS_REPOSITORY_BUFFER_SIZE", "1440");
            map.put("NIFI_COMPONENTS_STATUS_SNAPSHOT_FREQUENCY", "1 mins");

            map.put("NIFI_REMOTE_INPUT_HOST", "");
            map.put("NIFI_REMOTE_INPUT_SECURE", "false");
            map.put("NIFI_REMOTE_INPUT_SOCKET_PORT", "");
            map.put("NIFI_REMOTE_INPUT_HTTP_ENABLED", "true");
            map.put("NIFI_REMOTE_INPUT_HTTP_TRANSACTION_TTL", "30 secs");

            map.put("NIFI_WEB_WAR_DIRECTORY", "./lib");
            map.put("NIFI_WEB_HTTP_HOST", "");
            map.put("NIFI_WEB_HTTP_PORT", "8080");
            map.put("NIFI_WEB_HTTP_NETWORK_INTERFACE_DEFAULT", "");
            map.put("NIFI_WEB_HTTPS_HOST", "");
            map.put("NIFI_WEB_HTTPS_PORT", "8443");
            map.put("NIFI_WEB_HTTPS_NETWORK_INTERFACE_DEFAULT", "");
            map.put("NIFI_WEB_JETTY_WORKING_DIRECTORY", "./work/jetty");
            map.put("NIFI_WEB_JETTY_THREADS", "200");

            map.put("NIFI_SENSITIVE_PROPS_KEY", "");
            map.put("NIFI_SENSITIVE_PROPS_KEY_PROTECTED", "");
            map.put("NIFI_SENSITIVE_PROPS_ALGORITHM", "PBEWITHMD5AND256BITAES-CBC-OPENSSL");
            map.put("NIFI_SENSITIVE_PROPS_PROVIDER", "BC");
            map.put("NIFI_SENSITIVE_PROPS_ADDITIONAL_KEYS", "");

            map.put("NIFI_SECURITY_KEYSTORE", "");
            map.put("NIFI_SECURITY_KEYSTORETYPE", "");
            map.put("NIFI_SECURITY_KEYSTOREPASSWD", "");
            map.put("NIFI_SECURITY_KEYPASSWD", "");

            map.put("NIFI_SECURITY_TRUSTSTORE", "");
            map.put("NIFI_SECURITY_TRUSTSTORETYPE", "");
            map.put("NIFI_SECURITY_TRUSTSTOREPASSWD", "");

            map.put("NIFI_SECURITY_NEEDCLIENTAUTH", "");
            map.put("NIFI_SECURITY_USER_AUTHORIZER", "");
            map.put("NIFI_SECURITY_USER_LOGIN_IDENTITY_PROVIDER", "file-provider");
            map.put("NIFI_SECURITY_OCSP_RESPONDER_URL", "");
            map.put("NIFI_SECURITY_OCSP_RESPONDER_CERTIFICATE", "");

            map.put("NIFI_SECURITY_IDENTITY_MAPPING_PATTERN_DN", "^CN=(.*?), OU=(.*?), O=(.*?), L=(.*?), ST=(.*?), C=(.*?)$");
            map.put("NIFI_SECURITY_IDENTITY_MAPPING_VALUE_DN", "$1@$2");
            map.put("NIFI_SECURITY_IDENTITY_MAPPING_PATTERN_KERB", "^(.*?)/instance@(.*?)$");
            map.put("NIFI_SECURITY_IDENTITY_MAPPING_VALUE_KERB", "$1@$2");

            map.put("NIFI_CLUSTER_PROTOCOL_HEARTBEAT_INTERVAL", "5 secs");
            map.put("NIFI_CLUSTER_PROTOCOL_IS_SECURE", "false");

            map.put("NIFI_CLUSTER_IS_NODE", "true");
            map.put("NIFI_CLUSTER_NODE_ADDRESS", "");
            map.put("NIFI_CLUSTER_NODE_PROTOCOL_PORT", "0");
            map.put("NIFI_CLUSTER_NODE_PROTOCOL_THREADS", "10");
            map.put("NIFI_CLUSTER_NODE_EVENT_HISTORY_SIZE", "25");
            map.put("NIFI_CLUSTER_NODE_CONNECTION_TIMEOUT", "5 secs");
            map.put("NIFI_CLUSTER_NODE_READ_TIMEOUT", "5 secs");
            map.put("NIFI_CLUSTER_FIREWALL_FILE", "");
            map.put("NIFI_CLUSTER_FLOW_ELECTION_MAX_WAIT_TIME", "5 mins");
            map.put("NIFI_CLUSTER_FLOW_ELECTION_MAX_CANDIDATES", "");

            map.put("NIFI_ZOOKEEPER_CONNECT_STRING", "");
            map.put("NIFI_ZOOKEEPER_CONNECT_TIMEOUT", "3 secs");
            map.put("NIFI_ZOOKEEPER_SESSION_TIMEOUT", "3 secs");
            map.put("NIFI_ZOOKEEPER_ROOT_NODE", "/nifi");

            map.put("NIFI_KERBEROS_DEFAULT_REALM", "NIFI.APACHE.ORG");
            map.put("NIFI_KERBEROS_AUTHENTICATION_EXPIRATION", "12 hours");
            map.put("NIFI_KERBEROS_KRB5_FILE", "/etc/krb5.conf");
            map.put("NIFI_KERBEROS_SERVICE_PRINCIPAL", "");
            map.put("NIFI_KERBEROS_SERVICE_KEYTAB_LOCATION", "");
            map.put("NIFI_KERBEROS_SPNEGO_PRINCIPAL", "");
            map.put("NIFI_KERBEROS_SPNEGO_KEYTAB_LOCATION", "");
            map.put("NIFI_KERBEROS_SPNEGO_AUTHENTICATION_EXPIRATION", "12 hours");

            map.put("NIFI_VARIABLE_REGISTRY_PROPERTIES", "");

            return map;
    }
}