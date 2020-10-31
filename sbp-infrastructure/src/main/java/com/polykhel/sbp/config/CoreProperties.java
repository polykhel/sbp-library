package com.polykhel.sbp.config;

import com.polykhel.sbp.utils.constants.PropertyDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Properties for SSA configured in the {@code application.yml}.
 *
 * <p>Also loads properties from the git.properties and META-INF/build-info.properties files if they
 * are found in the classpath.
 */
@ConfigurationProperties(prefix = "core", ignoreUnknownFields = false)
@PropertySources({
    @PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
    @PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true)
})
@Component
public class CoreProperties {

    private final Async async = new Async();

    private final Http http = new Http();

    private final Database database = new Database();

    private final Cache cache = new Cache();

    private final Mail mail = new Mail();

    private final Security security = new Security();

    private final ApiDocs apiDocs = new ApiDocs();

    private final Metrics metrics = new Metrics();

    private final Logging logging = new Logging();

    private final CorsConfiguration cors = new CorsConfiguration();

    private final Social social = new Social();

    private final Gateway gateway = new Gateway();

    private final Registry registry = new Registry();

    private final ClientApp clientApp = new ClientApp();

    private final AuditEvents auditEvents = new AuditEvents();

    /**
     * <p>Getter for the field <code>async</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Async} object.
     */
    public Async getAsync() {
        return async;
    }

    /**
     * <p>Getter for the field <code>http</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Http} object.
     */
    public Http getHttp() {
        return http;
    }

    /**
     * <p>Getter for the field <code>database</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Database} object.
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * <p>Getter for the field <code>cache</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Cache} object.
     */
    public Cache getCache() {
        return cache;
    }

    /**
     * <p>Getter for the field <code>mail</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Mail} object.
     */
    public Mail getMail() {
        return mail;
    }

    /**
     * <p>Getter for the field <code>registry</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Registry} object.
     */
    public Registry getRegistry() {
        return registry;
    }

    /**
     * <p>Getter for the field <code>security</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Security} object.
     */
    public Security getSecurity() {
        return security;
    }

    /**
     * <p>Getter for the field <code>api-docs</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.ApiDocs} object.
     */
    public ApiDocs getApiDocs() {
        return apiDocs;
    }

    /**
     * <p>Getter for the field <code>metrics</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Metrics} object.
     */
    public Metrics getMetrics() {
        return metrics;
    }

    /**
     * <p>Getter for the field <code>logging</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Logging} object.
     */
    public Logging getLogging() {
        return logging;
    }

    /**
     * <p>Getter for the field <code>cors</code>.</p>
     *
     * @return a {@link org.springframework.web.cors.CorsConfiguration} object.
     */
    public CorsConfiguration getCors() {
        return cors;
    }

    /**
     * <p>Getter for the field <code>social</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Social} object.
     */
    public Social getSocial() {
        return social;
    }

    /**
     * <p>Getter for the field <code>gateway</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.Gateway} object.
     */
    public Gateway getGateway() {
        return gateway;
    }

    /**
     * <p>Getter for the field <code>clientApp</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.ClientApp} object.
     */
    public ClientApp getClientApp() {
        return clientApp;
    }

    /**
     * <p>Getter for the field <code>auditEvents</code>.</p>
     *
     * @return a {@link com.polykhel.sbp.config.CoreProperties.AuditEvents} object.
     */
    public AuditEvents getAuditEvents() {
        return auditEvents;
    }

    public static class Async {

        private int corePoolSize = PropertyDefaults.Async.corePoolSize;

        private int maxPoolSize = PropertyDefaults.Async.maxPoolSize;

        private int queueCapacity = PropertyDefaults.Async.queueCapacity;

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class Http {

        private final Cache cache = new Cache();

        public Cache getCache() {
            return cache;
        }

        public static class Cache {

            private int timeToLiveInDays = PropertyDefaults.Http.Cache.timeToLiveInDays;

            public int getTimeToLiveInDays() {
                return timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Database {

        private final Couchbase couchbase = new Couchbase();

        public Couchbase getCouchbase() {
            return couchbase;
        }

        public static class Couchbase {

            private String bucketName;

            public String getBucketName() {
                return bucketName;
            }

            public Couchbase setBucketName(String bucketName) {
                this.bucketName = bucketName;
                return this;
            }
        }
    }

    public static class Cache {

        private final Hazelcast hazelcast = new Hazelcast();

        private final Caffeine caffeine = new Caffeine();

        private final Ehcache ehcache = new Ehcache();

        private final Infinispan infinispan = new Infinispan();

        private final Memcached memcached = new Memcached();

        private final Redis redis = new Redis();

        public Hazelcast getHazelcast() {
            return hazelcast;
        }

        public Caffeine getCaffeine() {
            return caffeine;
        }

        public Ehcache getEhcache() {
            return ehcache;
        }

        public Infinispan getInfinispan() {
            return infinispan;
        }

        public Memcached getMemcached() {
            return memcached;
        }

        public Redis getRedis() {
            return redis;
        }

        public static class Hazelcast {

            private final ManagementCenter managementCenter = new ManagementCenter();
            private int timeToLiveSeconds = PropertyDefaults.Cache.Hazelcast.timeToLiveSeconds;
            private int backupCount = PropertyDefaults.Cache.Hazelcast.backupCount;

            /**
             * In the Hazelcast v4.x, the cluster node doesn't expose
             * configurations to connect to the management center. Setting up
             * of this property doesn't provide any behavior and has been
             * retained for the backward compatibility, and should be
             * removed in the next major release of the JHipster
             *
             * @return a {@link com.polykhel.sbp.config.CoreProperties.Cache.Hazelcast.ManagementCenter} object.
             */
            @Deprecated
            public ManagementCenter getManagementCenter() {
                return managementCenter;
            }

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public int getBackupCount() {
                return backupCount;
            }

            public void setBackupCount(int backupCount) {
                this.backupCount = backupCount;
            }

            /**
             * In the Hazelcast v4.x, the cluster node doesn't expose
             * configurations to connect to the management center. Setting up
             * of this class properties don't provide any behavior and has
             * been retained for the backward compatibility, and should be
             * removed in the next major release of the JHipster
             */
            @Deprecated
            public static class ManagementCenter {

                private boolean enabled = PropertyDefaults.Cache.Hazelcast.ManagementCenter.enabled;

                private int updateInterval = PropertyDefaults.Cache.Hazelcast.ManagementCenter.updateInterval;

                private String url = PropertyDefaults.Cache.Hazelcast.ManagementCenter.url;

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public int getUpdateInterval() {
                    return updateInterval;
                }

                public void setUpdateInterval(int updateInterval) {
                    this.updateInterval = updateInterval;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

            }
        }

        public static class Caffeine {

            private int timeToLiveSeconds = PropertyDefaults.Cache.Caffeine.timeToLiveSeconds;

            private long maxEntries = PropertyDefaults.Cache.Caffeine.maxEntries;

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Ehcache {

            private int timeToLiveSeconds = PropertyDefaults.Cache.Ehcache.timeToLiveSeconds;

            private long maxEntries = PropertyDefaults.Cache.Ehcache.maxEntries;

            public int getTimeToLiveSeconds() {
                return timeToLiveSeconds;
            }

            public void setTimeToLiveSeconds(int timeToLiveSeconds) {
                this.timeToLiveSeconds = timeToLiveSeconds;
            }

            public long getMaxEntries() {
                return maxEntries;
            }

            public void setMaxEntries(long maxEntries) {
                this.maxEntries = maxEntries;
            }
        }

        public static class Infinispan {

            private final Local local = new Local();
            private final Distributed distributed = new Distributed();
            private final Replicated replicated = new Replicated();
            private String configFile = PropertyDefaults.Cache.Infinispan.configFile;
            private boolean statsEnabled = PropertyDefaults.Cache.Infinispan.statsEnabled;

            public String getConfigFile() {
                return configFile;
            }

            public void setConfigFile(String configFile) {
                this.configFile = configFile;
            }

            public boolean isStatsEnabled() {
                return statsEnabled;
            }

            public void setStatsEnabled(boolean statsEnabled) {
                this.statsEnabled = statsEnabled;
            }

            public Local getLocal() {
                return local;
            }

            public Distributed getDistributed() {
                return distributed;
            }

            public Replicated getReplicated() {
                return replicated;
            }

            public static class Local {

                private long timeToLiveSeconds = PropertyDefaults.Cache.Infinispan.Local.timeToLiveSeconds;

                private long maxEntries = PropertyDefaults.Cache.Infinispan.Local.maxEntries;

                public long getTimeToLiveSeconds() {
                    return timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }

            }

            public static class Distributed {

                private long timeToLiveSeconds = PropertyDefaults.Cache.Infinispan.Distributed.timeToLiveSeconds;

                private long maxEntries = PropertyDefaults.Cache.Infinispan.Distributed.maxEntries;

                private int instanceCount = PropertyDefaults.Cache.Infinispan.Distributed.instanceCount;

                public long getTimeToLiveSeconds() {
                    return timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }

                public int getInstanceCount() {
                    return instanceCount;
                }

                public void setInstanceCount(int instanceCount) {
                    this.instanceCount = instanceCount;
                }
            }

            public static class Replicated {

                private long timeToLiveSeconds = PropertyDefaults.Cache.Infinispan.Replicated.timeToLiveSeconds;

                private long maxEntries = PropertyDefaults.Cache.Infinispan.Replicated.maxEntries;

                public long getTimeToLiveSeconds() {
                    return timeToLiveSeconds;
                }

                public void setTimeToLiveSeconds(long timeToLiveSeconds) {
                    this.timeToLiveSeconds = timeToLiveSeconds;
                }

                public long getMaxEntries() {
                    return maxEntries;
                }

                public void setMaxEntries(long maxEntries) {
                    this.maxEntries = maxEntries;
                }

            }
        }

        public static class Memcached {

            private boolean enabled = PropertyDefaults.Cache.Memcached.enabled;

            /**
             * Comma or whitespace separated list of servers' addresses.
             */
            private String servers = PropertyDefaults.Cache.Memcached.servers;

            private int expiration = PropertyDefaults.Cache.Memcached.expiration;

            private boolean useBinaryProtocol = PropertyDefaults.Cache.Memcached.useBinaryProtocol;

            private Authentication authentication = new Authentication();

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getServers() {
                return servers;
            }

            public void setServers(String servers) {
                this.servers = servers;
            }

            public int getExpiration() {
                return expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isUseBinaryProtocol() {
                return useBinaryProtocol;
            }

            public void setUseBinaryProtocol(boolean useBinaryProtocol) {
                this.useBinaryProtocol = useBinaryProtocol;
            }

            public Authentication getAuthentication() {
                return authentication;
            }

            public static class Authentication {

                private boolean enabled = PropertyDefaults.Cache.Memcached.Authentication.enabled;
                private String username;
                private String password;

                public boolean isEnabled() {
                    return enabled;
                }

                public Authentication setEnabled(boolean enabled) {
                    this.enabled = enabled;
                    return this;
                }

                public String getUsername() {
                    return username;
                }

                public Authentication setUsername(String username) {
                    this.username = username;
                    return this;
                }

                public String getPassword() {
                    return password;
                }

                public Authentication setPassword(String password) {
                    this.password = password;
                    return this;
                }
            }
        }

        public static class Redis {
            private String[] server = PropertyDefaults.Cache.Redis.server;
            private int expiration = PropertyDefaults.Cache.Redis.expiration;
            private boolean cluster = PropertyDefaults.Cache.Redis.cluster;
            private int connectionPoolSize = PropertyDefaults.Cache.Redis.connectionPoolSize;
            private int connectionMinimumIdleSize = PropertyDefaults.Cache.Redis.connectionMinimumIdleSize;
            private int subscriptionConnectionPoolSize = PropertyDefaults.Cache.Redis.subscriptionConnectionPoolSize;
            private int subscriptionConnectionMinimumIdleSize = PropertyDefaults.Cache.Redis.subscriptionConnectionMinimumIdleSize;

            public String[] getServer() {
                return server;
            }

            public void setServer(String[] server) {
                this.server = server;
            }

            public int getExpiration() {
                return expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public boolean isCluster() {
                return cluster;
            }

            public void setCluster(boolean cluster) {
                this.cluster = cluster;
            }

            public int getConnectionPoolSize() {
                return connectionPoolSize;
            }

            public Redis setConnectionPoolSize(int connectionPoolSize) {
                this.connectionPoolSize = connectionPoolSize;
                return this;
            }

            public int getConnectionMinimumIdleSize() {
                return connectionMinimumIdleSize;
            }

            public Redis setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
                this.connectionMinimumIdleSize = connectionMinimumIdleSize;
                return this;
            }

            public int getSubscriptionConnectionPoolSize() {
                return subscriptionConnectionPoolSize;
            }

            public Redis setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
                this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
                return this;
            }

            public int getSubscriptionConnectionMinimumIdleSize() {
                return subscriptionConnectionMinimumIdleSize;
            }

            public Redis setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
                this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
                return this;
            }
        }
    }

    public static class Mail {

        private boolean enabled = PropertyDefaults.Mail.enabled;

        private String from = PropertyDefaults.Mail.from;

        private String baseUrl = PropertyDefaults.Mail.baseUrl;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Security {

        private final ClientAuthorization clientAuthorization = new ClientAuthorization();

        private final Authentication authentication = new Authentication();

        private final RememberMe rememberMe = new RememberMe();

        private final OAuth2 oauth2 = new OAuth2();

        public ClientAuthorization getClientAuthorization() {
            return clientAuthorization;
        }

        public Authentication getAuthentication() {
            return authentication;
        }

        public RememberMe getRememberMe() {
            return rememberMe;
        }

        public OAuth2 getOauth2() {
            return oauth2;
        }

        public static class ClientAuthorization {

            private String accessTokenUri = PropertyDefaults.Security.ClientAuthorization.accessTokenUri;

            private String tokenServiceId = PropertyDefaults.Security.ClientAuthorization.tokenServiceId;

            private String clientId = PropertyDefaults.Security.ClientAuthorization.clientId;

            private String clientSecret = PropertyDefaults.Security.ClientAuthorization.clientSecret;

            public String getAccessTokenUri() {
                return accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }

        public static class Authentication {

            private final Jwt jwt = new Jwt();

            public Jwt getJwt() {
                return jwt;
            }

            public static class Jwt {

                private String secret = PropertyDefaults.Security.Authentication.Jwt.secret;

                private String base64Secret = PropertyDefaults.Security.Authentication.Jwt.base64Secret;

                private long tokenValidityInSeconds = PropertyDefaults.Security.Authentication.Jwt
                    .tokenValidityInSeconds;

                private long tokenValidityInSecondsForRememberMe = PropertyDefaults.Security.Authentication.Jwt
                    .tokenValidityInSecondsForRememberMe;

                public String getSecret() {
                    return secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class RememberMe {

            @NotNull
            private String key = PropertyDefaults.Security.RememberMe.key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class OAuth2 {
            private List<String> audience = new ArrayList<>();

            public List<String> getAudience() {
                return Collections.unmodifiableList(audience);
            }

            public void setAudience(@NotNull List<String> audience) {
                this.audience.addAll(audience);
            }
        }
    }

    public static class ApiDocs {

        private String title = PropertyDefaults.ApiDocs.title;

        private String description = PropertyDefaults.ApiDocs.description;

        private String version = PropertyDefaults.ApiDocs.version;

        private String termsOfServiceUrl = PropertyDefaults.ApiDocs.termsOfServiceUrl;

        private String contactName = PropertyDefaults.ApiDocs.contactName;

        private String contactUrl = PropertyDefaults.ApiDocs.contactUrl;

        private String contactEmail = PropertyDefaults.ApiDocs.contactEmail;

        private String license = PropertyDefaults.ApiDocs.license;

        private String licenseUrl = PropertyDefaults.ApiDocs.licenseUrl;

        private String defaultIncludePattern = PropertyDefaults.ApiDocs.defaultIncludePattern;

        private String host = PropertyDefaults.ApiDocs.host;

        private String[] protocols = PropertyDefaults.ApiDocs.protocols;

        private Server[] servers = {};

        private boolean useDefaultResponseMessages = PropertyDefaults.ApiDocs.useDefaultResponseMessages;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getHost() {
            return host;
        }

        public void setHost(final String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return protocols;
        }

        public void setProtocols(final String[] protocols) {
            this.protocols = protocols;
        }

        public Server[] getServers() {
            return servers;
        }

        public void setServers(final Server[] servers) {
            this.servers = servers;
        }

        public boolean isUseDefaultResponseMessages() {
            return useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(final boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }

        public static class Server {
            private String name;
            private String url;
            private String description;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

    public static class Metrics {

        private final Logs logs = new Logs();

        public Logs getLogs() {
            return logs;
        }

        public static class Logs {

            private boolean enabled = PropertyDefaults.Metrics.Logs.enabled;

            private long reportFrequency = PropertyDefaults.Metrics.Logs.reportFrequency;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getReportFrequency() {
                return reportFrequency;
            }

            public void setReportFrequency(long reportFrequency) {
                this.reportFrequency = reportFrequency;
            }
        }
    }

    public static class Logging {

        private final Logstash logstash = new Logstash();
        private boolean useJsonFormat = PropertyDefaults.Logging.useJsonFormat;

        public boolean isUseJsonFormat() {
            return useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public Logstash getLogstash() {
            return logstash;
        }

        public static class Logstash {

            private boolean enabled = PropertyDefaults.Logging.Logstash.enabled;

            private String host = PropertyDefaults.Logging.Logstash.host;

            private int port = PropertyDefaults.Logging.Logstash.port;

            private int queueSize = PropertyDefaults.Logging.Logstash.queueSize;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getQueueSize() {
                return queueSize;
            }

            public void setQueueSize(int queueSize) {
                this.queueSize = queueSize;
            }
        }
    }

    public static class Social {

        private String redirectAfterSignIn = PropertyDefaults.Social.redirectAfterSignIn;

        public String getRedirectAfterSignIn() {
            return redirectAfterSignIn;
        }

        public void setRedirectAfterSignIn(String redirectAfterSignIn) {
            this.redirectAfterSignIn = redirectAfterSignIn;
        }
    }

    public static class Gateway {

        private final RateLimiting rateLimiting = new RateLimiting();
        private Map<String, List<String>> authorizedMicroservicesEndpoints = PropertyDefaults.Gateway
            .authorizedMicroservicesEndpoints;

        public RateLimiting getRateLimiting() {
            return rateLimiting;
        }

        public Map<String, List<String>> getAuthorizedMicroservicesEndpoints() {
            return authorizedMicroservicesEndpoints;
        }

        public void setAuthorizedMicroservicesEndpoints(Map<String, List<String>> authorizedMicroservicesEndpoints) {
            this.authorizedMicroservicesEndpoints = authorizedMicroservicesEndpoints;
        }

        public static class RateLimiting {

            private boolean enabled = PropertyDefaults.Gateway.RateLimiting.enabled;

            private long limit = PropertyDefaults.Gateway.RateLimiting.limit;

            private int durationInSeconds = PropertyDefaults.Gateway.RateLimiting.durationInSeconds;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public long getLimit() {
                return this.limit;
            }

            public void setLimit(long limit) {
                this.limit = limit;
            }

            public int getDurationInSeconds() {
                return durationInSeconds;
            }

            public void setDurationInSeconds(int durationInSeconds) {
                this.durationInSeconds = durationInSeconds;
            }
        }
    }

    public static class Registry {

        private String password = PropertyDefaults.Registry.password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class ClientApp {

        private String name = PropertyDefaults.ClientApp.name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class AuditEvents {
        private int retentionPeriod = PropertyDefaults.AuditEvents.retentionPeriod;

        public int getRetentionPeriod() {
            return retentionPeriod;
        }

        public void setRetentionPeriod(int retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
        }
    }
}
