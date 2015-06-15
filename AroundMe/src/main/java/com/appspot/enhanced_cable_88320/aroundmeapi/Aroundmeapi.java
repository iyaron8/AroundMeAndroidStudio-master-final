/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-21 at 20:47:13 UTC 
 * Modify at your own risk.
 */

package com.appspot.enhanced_cable_88320.aroundmeapi;

/**
 * Service definition for Aroundmeapi (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link AroundmeapiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Aroundmeapi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

    // Note: Leave this static initializer at the top of the file.
    static {
        com.google.api.client.util.Preconditions.checkState(
                com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
                        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
                "You are currently running with version %s of google-api-client. " +
                        "You need at least version 1.15 of google-api-client to run version " +
                        "1.18.0-rc of the aroundmeapi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
    }

    /**
     * The default encoded root URL of the service. This is determined when the library is generated
     * and normally should not be changed.
     *
     * @since 1.7
     */
    public static final String DEFAULT_ROOT_URL = "https://enhanced-cable-88320.appspot.com/_ah/api/";

    /**
     * The default encoded service path of the service. This is determined when the library is
     * generated and normally should not be changed.
     *
     * @since 1.7
     */
    public static final String DEFAULT_SERVICE_PATH = "aroundmeapi/v1/";

    /**
     * The default encoded base URL of the service. This is determined when the library is generated
     * and normally should not be changed.
     */
    public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

    /**
     * Constructor.
     *
     * <p>
     * Use {@link Builder} if you need to specify any of the optional parameters.
     * </p>
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Aroundmeapi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
                       com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
        this(new Builder(transport, jsonFactory, httpRequestInitializer));
    }

    /**
     * @param builder builder
     */
    Aroundmeapi(Builder builder) {
        super(builder);
    }

    @Override
    protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
        super.initialize(httpClientRequest);
    }

    /**
     * Create a request for the method "getAllUsers".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link GetAllUsers#execute()} method to invoke the remote operation.
     *
     * @param userMail
     * @return the request
     */
    public GetAllUsers getAllUsers(java.lang.String userMail) throws java.io.IOException {
        GetAllUsers result = new GetAllUsers(userMail);
        initialize(result);
        return result;
    }

    public class GetAllUsers extends AroundmeapiRequest<com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection> {

        private static final String REST_PATH = "getAllUsers";

        /**
         * Create a request for the method "getAllUsers".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link GetAllUsers#execute()} method to invoke the remote
         * operation. <p> {@link
         * GetAllUsers#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
         * must be called to initialize this instance immediately after invoking the constructor. </p>
         *
         * @param userMail
         * @since 1.13
         */
        protected GetAllUsers(java.lang.String userMail) {
            super(Aroundmeapi.this, "GET", REST_PATH, null, com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection.class);
            this.userMail = com.google.api.client.util.Preconditions.checkNotNull(userMail, "Required parameter userMail must be specified.");
        }

        @Override
        public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
            return super.executeUsingHead();
        }

        @Override
        public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
            return super.buildHttpRequestUsingHead();
        }

        @Override
        public GetAllUsers setAlt(java.lang.String alt) {
            return (GetAllUsers) super.setAlt(alt);
        }

        @Override
        public GetAllUsers setFields(java.lang.String fields) {
            return (GetAllUsers) super.setFields(fields);
        }

        @Override
        public GetAllUsers setKey(java.lang.String key) {
            return (GetAllUsers) super.setKey(key);
        }

        @Override
        public GetAllUsers setOauthToken(java.lang.String oauthToken) {
            return (GetAllUsers) super.setOauthToken(oauthToken);
        }

        @Override
        public GetAllUsers setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (GetAllUsers) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public GetAllUsers setQuotaUser(java.lang.String quotaUser) {
            return (GetAllUsers) super.setQuotaUser(quotaUser);
        }

        @Override
        public GetAllUsers setUserIp(java.lang.String userIp) {
            return (GetAllUsers) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.String userMail;

        /**
         */
        public java.lang.String getUserMail() {
            return userMail;
        }

        public GetAllUsers setUserMail(java.lang.String userMail) {
            this.userMail = userMail;
            return this;
        }

        @Override
        public GetAllUsers set(String parameterName, Object value) {
            return (GetAllUsers) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "getMessage".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link GetMessage#execute()} method to invoke the remote operation.
     *
     * @param messageId
     * @return the request
     */
    public GetMessage getMessage(java.lang.Long messageId) throws java.io.IOException {
        GetMessage result = new GetMessage(messageId);
        initialize(result);
        return result;
    }

    public class GetMessage extends AroundmeapiRequest<com.appspot.enhanced_cable_88320.aroundmeapi.model.Message> {

        private static final String REST_PATH = "getMessage";

        /**
         * Create a request for the method "getMessage".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link GetMessage#execute()} method to invoke the remote
         * operation. <p> {@link
         * GetMessage#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
         * must be called to initialize this instance immediately after invoking the constructor. </p>
         *
         * @param messageId
         * @since 1.13
         */
        protected GetMessage(java.lang.Long messageId) {
            super(Aroundmeapi.this, "GET", REST_PATH, null, com.appspot.enhanced_cable_88320.aroundmeapi.model.Message.class);
            this.messageId = com.google.api.client.util.Preconditions.checkNotNull(messageId, "Required parameter messageId must be specified.");
        }

        @Override
        public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
            return super.executeUsingHead();
        }

        @Override
        public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
            return super.buildHttpRequestUsingHead();
        }

        @Override
        public GetMessage setAlt(java.lang.String alt) {
            return (GetMessage) super.setAlt(alt);
        }

        @Override
        public GetMessage setFields(java.lang.String fields) {
            return (GetMessage) super.setFields(fields);
        }

        @Override
        public GetMessage setKey(java.lang.String key) {
            return (GetMessage) super.setKey(key);
        }

        @Override
        public GetMessage setOauthToken(java.lang.String oauthToken) {
            return (GetMessage) super.setOauthToken(oauthToken);
        }

        @Override
        public GetMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (GetMessage) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public GetMessage setQuotaUser(java.lang.String quotaUser) {
            return (GetMessage) super.setQuotaUser(quotaUser);
        }

        @Override
        public GetMessage setUserIp(java.lang.String userIp) {
            return (GetMessage) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.Long messageId;

        /**
         */
        public java.lang.Long getMessageId() {
            return messageId;
        }

        public GetMessage setMessageId(java.lang.Long messageId) {
            this.messageId = messageId;
            return this;
        }

        @Override
        public GetMessage set(String parameterName, Object value) {
            return (GetMessage) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "getUsersAroundMe".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link GetUsersAroundMe#execute()} method to invoke the remote operation.
     *
     * @param lat
     * @param lng
     * @param radius
     * @param userMail
     * @return the request
     */
    public GetUsersAroundMe getUsersAroundMe(java.lang.Float lat, java.lang.Float lng, java.lang.Integer radius, java.lang.String userMail) throws java.io.IOException {
        GetUsersAroundMe result = new GetUsersAroundMe(lat, lng, radius, userMail);
        initialize(result);
        return result;
    }

    public class GetUsersAroundMe extends AroundmeapiRequest<com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection> {

        private static final String REST_PATH = "getUsersAroundMe";

        /**
         * Create a request for the method "getUsersAroundMe".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link GetUsersAroundMe#execute()} method to invoke the remote
         * operation. <p> {@link GetUsersAroundMe#initialize(com.google.api.client.googleapis.services.Abs
         * tractGoogleClientRequest)} must be called to initialize this instance immediately after
         * invoking the constructor. </p>
         *
         * @param lat
         * @param lng
         * @param radius
         * @param userMail
         * @since 1.13
         */
        protected GetUsersAroundMe(java.lang.Float lat, java.lang.Float lng, java.lang.Integer radius, java.lang.String userMail) {
            super(Aroundmeapi.this, "GET", REST_PATH, null, com.appspot.enhanced_cable_88320.aroundmeapi.model.UserAroundMeCollection.class);
            this.lat = com.google.api.client.util.Preconditions.checkNotNull(lat, "Required parameter lat must be specified.");
            this.lng = com.google.api.client.util.Preconditions.checkNotNull(lng, "Required parameter lng must be specified.");
            this.radius = com.google.api.client.util.Preconditions.checkNotNull(radius, "Required parameter radius must be specified.");
            this.userMail = com.google.api.client.util.Preconditions.checkNotNull(userMail, "Required parameter userMail must be specified.");
        }

        @Override
        public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
            return super.executeUsingHead();
        }

        @Override
        public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
            return super.buildHttpRequestUsingHead();
        }

        @Override
        public GetUsersAroundMe setAlt(java.lang.String alt) {
            return (GetUsersAroundMe) super.setAlt(alt);
        }

        @Override
        public GetUsersAroundMe setFields(java.lang.String fields) {
            return (GetUsersAroundMe) super.setFields(fields);
        }

        @Override
        public GetUsersAroundMe setKey(java.lang.String key) {
            return (GetUsersAroundMe) super.setKey(key);
        }

        @Override
        public GetUsersAroundMe setOauthToken(java.lang.String oauthToken) {
            return (GetUsersAroundMe) super.setOauthToken(oauthToken);
        }

        @Override
        public GetUsersAroundMe setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (GetUsersAroundMe) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public GetUsersAroundMe setQuotaUser(java.lang.String quotaUser) {
            return (GetUsersAroundMe) super.setQuotaUser(quotaUser);
        }

        @Override
        public GetUsersAroundMe setUserIp(java.lang.String userIp) {
            return (GetUsersAroundMe) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.Float lat;

        /**
         */
        public java.lang.Float getLat() {
            return lat;
        }

        public GetUsersAroundMe setLat(java.lang.Float lat) {
            this.lat = lat;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.Float lng;

        /**
         */
        public java.lang.Float getLng() {
            return lng;
        }

        public GetUsersAroundMe setLng(java.lang.Float lng) {
            this.lng = lng;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.Integer radius;

        /**
         */
        public java.lang.Integer getRadius() {
            return radius;
        }

        public GetUsersAroundMe setRadius(java.lang.Integer radius) {
            this.radius = radius;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.String userMail;

        /**
         */
        public java.lang.String getUserMail() {
            return userMail;
        }

        public GetUsersAroundMe setUserMail(java.lang.String userMail) {
            this.userMail = userMail;
            return this;
        }

        @Override
        public GetUsersAroundMe set(String parameterName, Object value) {
            return (GetUsersAroundMe) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "login".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link Login#execute()} method to invoke the remote operation.
     *
     * @param mail
     * @param password
     * @param registrationId
     * @return the request
     */
    public Login login(java.lang.String mail, java.lang.String password, java.lang.String registrationId) throws java.io.IOException {
        Login result = new Login(mail, password, registrationId);
        initialize(result);
        return result;
    }

    public class Login extends AroundmeapiRequest<com.appspot.enhanced_cable_88320.aroundmeapi.model.User> {

        private static final String REST_PATH = "login";

        /**
         * Create a request for the method "login".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link Login#execute()} method to invoke the remote operation.
         * <p> {@link
         * Login#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
         * be called to initialize this instance immediately after invoking the constructor. </p>
         *
         * @param mail
         * @param password
         * @param registrationId
         * @since 1.13
         */
        protected Login(java.lang.String mail, java.lang.String password, java.lang.String registrationId) {
            super(Aroundmeapi.this, "POST", REST_PATH, null, com.appspot.enhanced_cable_88320.aroundmeapi.model.User.class);
            this.mail = com.google.api.client.util.Preconditions.checkNotNull(mail, "Required parameter mail must be specified.");
            this.password = com.google.api.client.util.Preconditions.checkNotNull(password, "Required parameter password must be specified.");
            this.registrationId = com.google.api.client.util.Preconditions.checkNotNull(registrationId, "Required parameter registrationId must be specified.");
        }

        @Override
        public Login setAlt(java.lang.String alt) {
            return (Login) super.setAlt(alt);
        }

        @Override
        public Login setFields(java.lang.String fields) {
            return (Login) super.setFields(fields);
        }

        @Override
        public Login setKey(java.lang.String key) {
            return (Login) super.setKey(key);
        }

        @Override
        public Login setOauthToken(java.lang.String oauthToken) {
            return (Login) super.setOauthToken(oauthToken);
        }

        @Override
        public Login setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (Login) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public Login setQuotaUser(java.lang.String quotaUser) {
            return (Login) super.setQuotaUser(quotaUser);
        }

        @Override
        public Login setUserIp(java.lang.String userIp) {
            return (Login) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.String mail;

        /**
         */
        public java.lang.String getMail() {
            return mail;
        }

        public Login setMail(java.lang.String mail) {
            this.mail = mail;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.String password;

        /**
         */
        public java.lang.String getPassword() {
            return password;
        }

        public Login setPassword(java.lang.String password) {
            this.password = password;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.String registrationId;

        /**
         */
        public java.lang.String getRegistrationId() {
            return registrationId;
        }

        public Login setRegistrationId(java.lang.String registrationId) {
            this.registrationId = registrationId;
            return this;
        }

        @Override
        public Login set(String parameterName, Object value) {
            return (Login) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "register".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link Register#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.User}
     * @return the request
     */
    public Register register(com.appspot.enhanced_cable_88320.aroundmeapi.model.User content) throws java.io.IOException {
        Register result = new Register(content);
        initialize(result);
        return result;
    }

    public class Register extends AroundmeapiRequest<com.appspot.enhanced_cable_88320.aroundmeapi.model.User> {

        private static final String REST_PATH = "register";

        /**
         * Create a request for the method "register".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link Register#execute()} method to invoke the remote operation.
         * <p> {@link
         * Register#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
         * must be called to initialize this instance immediately after invoking the constructor. </p>
         *
         * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.User}
         * @since 1.13
         */
        protected Register(com.appspot.enhanced_cable_88320.aroundmeapi.model.User content) {
            super(Aroundmeapi.this, "POST", REST_PATH, content, com.appspot.enhanced_cable_88320.aroundmeapi.model.User.class);
        }

        @Override
        public Register setAlt(java.lang.String alt) {
            return (Register) super.setAlt(alt);
        }

        @Override
        public Register setFields(java.lang.String fields) {
            return (Register) super.setFields(fields);
        }

        @Override
        public Register setKey(java.lang.String key) {
            return (Register) super.setKey(key);
        }

        @Override
        public Register setOauthToken(java.lang.String oauthToken) {
            return (Register) super.setOauthToken(oauthToken);
        }

        @Override
        public Register setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (Register) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public Register setQuotaUser(java.lang.String quotaUser) {
            return (Register) super.setQuotaUser(quotaUser);
        }

        @Override
        public Register setUserIp(java.lang.String userIp) {
            return (Register) super.setUserIp(userIp);
        }

        @Override
        public Register set(String parameterName, Object value) {
            return (Register) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "reportUserLocation".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link ReportUserLocation#execute()} method to invoke the remote operation.
     *
     * @param mail
     * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.GeoPt}
     * @return the request
     */
    public ReportUserLocation reportUserLocation(java.lang.String mail, com.appspot.enhanced_cable_88320.aroundmeapi.model.GeoPt content) throws java.io.IOException {
        ReportUserLocation result = new ReportUserLocation(mail, content);
        initialize(result);
        return result;
    }

    public class ReportUserLocation extends AroundmeapiRequest<Void> {

        private static final String REST_PATH = "reportUserLocation";

        /**
         * Create a request for the method "reportUserLocation".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link ReportUserLocation#execute()} method to invoke the remote
         * operation. <p> {@link ReportUserLocation#initialize(com.google.api.client.googleapis.services.A
         * bstractGoogleClientRequest)} must be called to initialize this instance immediately after
         * invoking the constructor. </p>
         *
         * @param mail
         * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.GeoPt}
         * @since 1.13
         */
        protected ReportUserLocation(java.lang.String mail, com.appspot.enhanced_cable_88320.aroundmeapi.model.GeoPt content) {
            super(Aroundmeapi.this, "POST", REST_PATH, content, Void.class);
            this.mail = com.google.api.client.util.Preconditions.checkNotNull(mail, "Required parameter mail must be specified.");
        }

        @Override
        public ReportUserLocation setAlt(java.lang.String alt) {
            return (ReportUserLocation) super.setAlt(alt);
        }

        @Override
        public ReportUserLocation setFields(java.lang.String fields) {
            return (ReportUserLocation) super.setFields(fields);
        }

        @Override
        public ReportUserLocation setKey(java.lang.String key) {
            return (ReportUserLocation) super.setKey(key);
        }

        @Override
        public ReportUserLocation setOauthToken(java.lang.String oauthToken) {
            return (ReportUserLocation) super.setOauthToken(oauthToken);
        }

        @Override
        public ReportUserLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (ReportUserLocation) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public ReportUserLocation setQuotaUser(java.lang.String quotaUser) {
            return (ReportUserLocation) super.setQuotaUser(quotaUser);
        }

        @Override
        public ReportUserLocation setUserIp(java.lang.String userIp) {
            return (ReportUserLocation) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.String mail;

        /**
         */
        public java.lang.String getMail() {
            return mail;
        }

        public ReportUserLocation setMail(java.lang.String mail) {
            this.mail = mail;
            return this;
        }

        @Override
        public ReportUserLocation set(String parameterName, Object value) {
            return (ReportUserLocation) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "sendGcmMessage".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link SendGcmMessage#execute()} method to invoke the remote operation.
     *
     * @param mail
     * @param message
     * @return the request
     */
    public SendGcmMessage sendGcmMessage(java.lang.String mail, java.lang.String message) throws java.io.IOException {
        SendGcmMessage result = new SendGcmMessage(mail, message);
        initialize(result);
        return result;
    }

    public class SendGcmMessage extends AroundmeapiRequest<Void> {

        private static final String REST_PATH = "sendGcmMessage";

        /**
         * Create a request for the method "sendGcmMessage".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link SendGcmMessage#execute()} method to invoke the remote
         * operation. <p> {@link SendGcmMessage#initialize(com.google.api.client.googleapis.services.Abstr
         * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
         * the constructor. </p>
         *
         * @param mail
         * @param message
         * @since 1.13
         */
        protected SendGcmMessage(java.lang.String mail, java.lang.String message) {
            super(Aroundmeapi.this, "POST", REST_PATH, null, Void.class);
            this.mail = com.google.api.client.util.Preconditions.checkNotNull(mail, "Required parameter mail must be specified.");
            this.message = com.google.api.client.util.Preconditions.checkNotNull(message, "Required parameter message must be specified.");
        }

        @Override
        public SendGcmMessage setAlt(java.lang.String alt) {
            return (SendGcmMessage) super.setAlt(alt);
        }

        @Override
        public SendGcmMessage setFields(java.lang.String fields) {
            return (SendGcmMessage) super.setFields(fields);
        }

        @Override
        public SendGcmMessage setKey(java.lang.String key) {
            return (SendGcmMessage) super.setKey(key);
        }

        @Override
        public SendGcmMessage setOauthToken(java.lang.String oauthToken) {
            return (SendGcmMessage) super.setOauthToken(oauthToken);
        }

        @Override
        public SendGcmMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (SendGcmMessage) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public SendGcmMessage setQuotaUser(java.lang.String quotaUser) {
            return (SendGcmMessage) super.setQuotaUser(quotaUser);
        }

        @Override
        public SendGcmMessage setUserIp(java.lang.String userIp) {
            return (SendGcmMessage) super.setUserIp(userIp);
        }

        @com.google.api.client.util.Key
        private java.lang.String mail;

        /**
         */
        public java.lang.String getMail() {
            return mail;
        }

        public SendGcmMessage setMail(java.lang.String mail) {
            this.mail = mail;
            return this;
        }

        @com.google.api.client.util.Key
        private java.lang.String message;

        /**
         */
        public java.lang.String getMessage() {
            return message;
        }

        public SendGcmMessage setMessage(java.lang.String message) {
            this.message = message;
            return this;
        }

        @Override
        public SendGcmMessage set(String parameterName, Object value) {
            return (SendGcmMessage) super.set(parameterName, value);
        }
    }

    /**
     * Create a request for the method "sendMessage".
     *
     * This request holds the parameters needed by the aroundmeapi server.  After setting any optional
     * parameters, call the {@link SendMessage#execute()} method to invoke the remote operation.
     *
     * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.Message}
     * @return the request
     */
    public SendMessage sendMessage(com.appspot.enhanced_cable_88320.aroundmeapi.model.Message content) throws java.io.IOException {
        SendMessage result = new SendMessage(content);
        initialize(result);
        return result;
    }

    public class SendMessage extends AroundmeapiRequest<Void> {

        private static final String REST_PATH = "sendMessage";

        /**
         * Create a request for the method "sendMessage".
         *
         * This request holds the parameters needed by the the aroundmeapi server.  After setting any
         * optional parameters, call the {@link SendMessage#execute()} method to invoke the remote
         * operation. <p> {@link
         * SendMessage#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
         * must be called to initialize this instance immediately after invoking the constructor. </p>
         *
         * @param content the {@link com.appspot.enhanced_cable_88320.aroundmeapi.model.Message}
         * @since 1.13
         */
        protected SendMessage(com.appspot.enhanced_cable_88320.aroundmeapi.model.Message content) {
            super(Aroundmeapi.this, "POST", REST_PATH, content, Void.class);
        }

        @Override
        public SendMessage setAlt(java.lang.String alt) {
            return (SendMessage) super.setAlt(alt);
        }

        @Override
        public SendMessage setFields(java.lang.String fields) {
            return (SendMessage) super.setFields(fields);
        }

        @Override
        public SendMessage setKey(java.lang.String key) {
            return (SendMessage) super.setKey(key);
        }

        @Override
        public SendMessage setOauthToken(java.lang.String oauthToken) {
            return (SendMessage) super.setOauthToken(oauthToken);
        }

        @Override
        public SendMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
            return (SendMessage) super.setPrettyPrint(prettyPrint);
        }

        @Override
        public SendMessage setQuotaUser(java.lang.String quotaUser) {
            return (SendMessage) super.setQuotaUser(quotaUser);
        }

        @Override
        public SendMessage setUserIp(java.lang.String userIp) {
            return (SendMessage) super.setUserIp(userIp);
        }

        @Override
        public SendMessage set(String parameterName, Object value) {
            return (SendMessage) super.set(parameterName, value);
        }
    }

    /**
     * Builder for {@link Aroundmeapi}.
     *
     * <p>
     * Implementation is not thread-safe.
     * </p>
     *
     * @since 1.3.0
     */
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

        /**
         * Returns an instance of a new builder.
         *
         * @param transport HTTP transport, which should normally be:
         *        <ul>
         *        <li>Google App Engine:
         *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
         *        <li>Android: {@code newCompatibleTransport} from
         *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
         *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
         *        </li>
         *        </ul>
         * @param jsonFactory JSON factory, which may be:
         *        <ul>
         *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
         *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
         *        <li>Android Honeycomb or higher:
         *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
         *        </ul>
         * @param httpRequestInitializer HTTP request initializer or {@code null} for none
         * @since 1.7
         */
        public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
                       com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
            super(
                    transport,
                    jsonFactory,
                    DEFAULT_ROOT_URL,
                    DEFAULT_SERVICE_PATH,
                    httpRequestInitializer,
                    false);
        }

        /** Builds a new instance of {@link Aroundmeapi}. */
        @Override
        public Aroundmeapi build() {
            return new Aroundmeapi(this);
        }

        @Override
        public Builder setRootUrl(String rootUrl) {
            return (Builder) super.setRootUrl(rootUrl);
        }

        @Override
        public Builder setServicePath(String servicePath) {
            return (Builder) super.setServicePath(servicePath);
        }

        @Override
        public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
            return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
        }

        @Override
        public Builder setApplicationName(String applicationName) {
            return (Builder) super.setApplicationName(applicationName);
        }

        @Override
        public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
            return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
        }

        @Override
        public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
            return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
        }

        @Override
        public Builder setSuppressAllChecks(boolean suppressAllChecks) {
            return (Builder) super.setSuppressAllChecks(suppressAllChecks);
        }

        /**
         * Set the {@link AroundmeapiRequestInitializer}.
         *
         * @since 1.12
         */
        public Builder setAroundmeapiRequestInitializer(
                AroundmeapiRequestInitializer aroundmeapiRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(aroundmeapiRequestInitializer);
        }

        @Override
        public Builder setGoogleClientRequestInitializer(
                com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }
}