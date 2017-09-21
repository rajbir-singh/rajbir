package com.rajbir.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Sony on 10-09-2017.
 */

@RestController
public abstract class BaseController {

    public static ResponseEntity ok(){
        return new ResponseEntity(HttpStatus.OK);
    }

    public static ResponseEntity continueRes(Object object){
        return new ResponseEntity(object,HttpStatus.CONTINUE);
    }

    public static ResponseEntity switchingProtocols(Object object){
        return new ResponseEntity(object,HttpStatus.SWITCHING_PROTOCOLS);
    }

    public static ResponseEntity processing(Object object){
        return new ResponseEntity(object,HttpStatus.PROCESSING);
    }

    public static ResponseEntity checkpoint(Object object){
        return new ResponseEntity(object,HttpStatus.CHECKPOINT);
    }

    public static ResponseEntity ok(Object object){
        return new ResponseEntity(object,HttpStatus.OK);
    }

    public static ResponseEntity created(){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public static ResponseEntity created(Object object){
        return new ResponseEntity(object,HttpStatus.CREATED);
    }

    public static ResponseEntity accepted(){
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public static ResponseEntity accepted(Object object){
        return new ResponseEntity(object,HttpStatus.ACCEPTED);
    }

    public static ResponseEntity nonAuthoritativeInformation(Object object){
        return new ResponseEntity(object,HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

    public static ResponseEntity noContent(){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity noContent(Object object){
        return new ResponseEntity(object,HttpStatus.NO_CONTENT);
    }

    public static ResponseEntity resetContent(Object object){
        return new ResponseEntity(object,HttpStatus.RESET_CONTENT);
    }

    public static ResponseEntity partialContent(Object object){
        return new ResponseEntity(object,HttpStatus.PARTIAL_CONTENT);
    }

    public static ResponseEntity multiStatus(Object object){
        return new ResponseEntity(object,HttpStatus.MULTI_STATUS);
    }

    public static ResponseEntity alreadyReported(Object object){
        return new ResponseEntity(object,HttpStatus.ALREADY_REPORTED);
    }

    public static ResponseEntity imUsed(Object object){
        return new ResponseEntity(object,HttpStatus.IM_USED);
    }

    public static ResponseEntity multipleChoices(Object object){
        return new ResponseEntity(object,HttpStatus.MULTIPLE_CHOICES);
    }

    public static ResponseEntity movedPermanently(Object object){
        return new ResponseEntity(object,HttpStatus.MOVED_PERMANENTLY);
    }

    public static ResponseEntity found(Object object){
        return new ResponseEntity(object,HttpStatus.FOUND);
    }

    public static ResponseEntity movedTemporarily(Object object){
        return new ResponseEntity(object,HttpStatus.MOVED_TEMPORARILY);
    }

    public static ResponseEntity seeOther(Object object){
        return new ResponseEntity(object,HttpStatus.SEE_OTHER);
    }

    public static ResponseEntity notModified(){
        return new ResponseEntity(null,HttpStatus.NOT_MODIFIED);
    }

    public static ResponseEntity notModified(Object object){
        return new ResponseEntity(object,HttpStatus.NOT_MODIFIED);
    }

    public static ResponseEntity useProxy(Object object){
        return new ResponseEntity(object,HttpStatus.USE_PROXY);
    }

    public static ResponseEntity temporaryRedirect(Object object){
        return new ResponseEntity(object,HttpStatus.TEMPORARY_REDIRECT);
    }

    public static ResponseEntity permanentRedirect(Object object){
        return new ResponseEntity(object,HttpStatus.PERMANENT_REDIRECT);
    }

    public static ResponseEntity badRequest(Object object){
        return new ResponseEntity(object,HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity unauthorized(Object object){
        return new ResponseEntity(object,HttpStatus.UNAUTHORIZED);
    }

    public static ResponseEntity paymentRequired(Object object){
        return new ResponseEntity(object,HttpStatus.PAYMENT_REQUIRED);
    }

    public static ResponseEntity forbidden(Object object){
        return new ResponseEntity(object,HttpStatus.FORBIDDEN);
    }

    public static ResponseEntity notFound(Object object){
        return new ResponseEntity(object,HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity methodNotAllowed(Object object){
        return new ResponseEntity(object,HttpStatus.METHOD_NOT_ALLOWED);
    }

    public static ResponseEntity notAcceptable(Object object){
        return new ResponseEntity(object,HttpStatus.NOT_ACCEPTABLE);
    }

    public static ResponseEntity proxyAuthenticationRequired(Object object){
        return new ResponseEntity(object,HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
    }

    public static ResponseEntity requestTimeout(Object object){
        return new ResponseEntity(object,HttpStatus.REQUEST_TIMEOUT);
    }

    public static ResponseEntity conflict(Object object){
        return new ResponseEntity(object,HttpStatus.CONFLICT);
    }

    public static ResponseEntity gone(Object object){
        return new ResponseEntity(object,HttpStatus.GONE);
    }

    public static ResponseEntity lengthRequired(Object object){
        return new ResponseEntity(object,HttpStatus.LENGTH_REQUIRED);
    }

    public static ResponseEntity preconditionFailed(Object object){
        return new ResponseEntity(object,HttpStatus.PRECONDITION_FAILED);
    }

    public static ResponseEntity payloadTooLarge(Object object){
        return new ResponseEntity(object,HttpStatus.PAYLOAD_TOO_LARGE);
    }

    public static ResponseEntity requestEntityTooLarge(Object object){
        return new ResponseEntity(object,HttpStatus.REQUEST_ENTITY_TOO_LARGE);
    }

    public static ResponseEntity uriTooLong(Object object){
        return new ResponseEntity(object,HttpStatus.URI_TOO_LONG);
    }

    public static ResponseEntity requestUriTooLong(Object object){
        return new ResponseEntity(object,HttpStatus.REQUEST_URI_TOO_LONG);
    }

    public static ResponseEntity unsupportedMediaType(Object object){
        return new ResponseEntity(object,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    public static ResponseEntity requestedRangeNotSatisfiable(Object object){
        return new ResponseEntity(object,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
    }

    public static ResponseEntity expectationFailed(Object object){
        return new ResponseEntity(object,HttpStatus.EXPECTATION_FAILED);
    }

    public static ResponseEntity iAmATeapot(Object object){
        return new ResponseEntity(object,HttpStatus.I_AM_A_TEAPOT);
    }

    public static ResponseEntity insufficientSpaceOnResource(Object object){
        return new ResponseEntity(object,HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE);
    }

    public static ResponseEntity methodFailure(Object object){
        return new ResponseEntity(object,HttpStatus.METHOD_FAILURE);
    }

    public static ResponseEntity destinationLocked(Object object){
        return new ResponseEntity(object,HttpStatus.DESTINATION_LOCKED);
    }

    public static ResponseEntity unprocessableEntity(Object object){
        return new ResponseEntity(object,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public static ResponseEntity locked(Object object){
        return new ResponseEntity(object,HttpStatus.LOCKED);
    }

    public static ResponseEntity failedDependency(Object object){
        return new ResponseEntity(object,HttpStatus.FAILED_DEPENDENCY);
    }

    public static ResponseEntity upgradeRequired(Object object){
        return new ResponseEntity(object,HttpStatus.UPGRADE_REQUIRED);
    }

    public static ResponseEntity preconditionRequired(Object object){
        return new ResponseEntity(object,HttpStatus.PRECONDITION_REQUIRED);
    }

    public static ResponseEntity tooManyRequests(Object object){
        return new ResponseEntity(object,HttpStatus.TOO_MANY_REQUESTS);
    }

    public static ResponseEntity requestHeaderFieldsTooLarge(Object object){
        return new ResponseEntity(object,HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

    public static ResponseEntity internalServerError(Object object){
        return new ResponseEntity(object,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity notImplemented(Object object){
        return new ResponseEntity(object,HttpStatus.NOT_IMPLEMENTED);
    }

    public static ResponseEntity badGateway(Object object){
        return new ResponseEntity(object,HttpStatus.BAD_GATEWAY);
    }

    public static ResponseEntity serviceUnavailable(Object object){
        return new ResponseEntity(object,HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static ResponseEntity gatewayTimeout(Object object){
        return new ResponseEntity(object,HttpStatus.GATEWAY_TIMEOUT);
    }

    public static ResponseEntity httpVersionNotSupported(Object object){
        return new ResponseEntity(object,HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
    }

    public static ResponseEntity variantAlsoNegotiates(Object object){
        return new ResponseEntity(object,HttpStatus.VARIANT_ALSO_NEGOTIATES);
    }

    public static ResponseEntity insufficientStorage(Object object){
        return new ResponseEntity(object,HttpStatus.INSUFFICIENT_STORAGE);
    }

    public static ResponseEntity loopDetected(Object object){
        return new ResponseEntity(object,HttpStatus.LOOP_DETECTED);
    }

    public static ResponseEntity bandwidthLimitExceeded(Object object){
        return new ResponseEntity(object,HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    public static ResponseEntity notExtended(Object object){
        return new ResponseEntity(object,HttpStatus.NOT_EXTENDED);
    }

    public static ResponseEntity networkAuthenticationRequired(Object object){
        return new ResponseEntity(object,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    public static ResponseEntity redirect(String externalurl) throws URISyntaxException {
        URI yahoo = new URI(externalurl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(yahoo);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    public static <T> RestResponse<T> newRestResponse(T data) {
        return newRestResponse(data, true, null);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, String errorMessage) {
        return newRestResponse(data, true, errorMessage);
    }

    protected static <T> RestResponse<T> newRestResponse(T data, boolean status) {
        return newRestResponse(data, status, null);
    }

    protected static <T> RestResponse<T> newRestResponse(boolean status, String errorMessage) {
        return newRestResponse(null, status, errorMessage);
    }

    protected static <T> RestResponse<T> errorResponse(List<FieldError> fieldErrors) {
        return new RestResponse<>(null, false, getErrors(fieldErrors));
    }

    protected static <T> RestResponse<T> newRestResponse(T data, boolean status, String errorMessage) {

        return new RestResponse<>(data, status, errorMessage);
    }

    protected static String getErrors(List<FieldError> fieldErrors) {
        StringBuffer buffer = new StringBuffer();
        String prefix = "";
        for (FieldError error : fieldErrors) {
            buffer.append(prefix);
            prefix = " , ";
            buffer.append(error.getDefaultMessage());
        }
        return buffer.toString();
    }
}

