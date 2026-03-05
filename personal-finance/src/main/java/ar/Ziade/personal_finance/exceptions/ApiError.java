package ar.Ziade.personal_finance.exceptions;

import java.time.LocalDateTime;

/**
 * standar API response returned when an exception occurs
 * @param timestamp the time where the exception was trigger
 * @param status the HTTP status code
 * @param error the type of conflict error in the status code
 * @param message this is to tell what exactly went wrong
 * @param path where it go wrong
 */
public record ApiError(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
