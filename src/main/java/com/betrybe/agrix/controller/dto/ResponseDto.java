package com.betrybe.agrix.controller.dto;

/**
 * Dto of the application response layer.
 *
 * @param message message to be sent in the response
 * @param info information to be sent in the response
 * @param <T> generic type for Dto reuse
 */
public record ResponseDto<T>(String message, T info) {
}
