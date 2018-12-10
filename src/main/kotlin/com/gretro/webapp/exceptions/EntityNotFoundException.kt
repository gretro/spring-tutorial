package com.gretro.webapp.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(HttpStatus.NOT_FOUND, reason = "Could not find entity")
class EntityNotFoundException(entityType: String, id: Any) : Exception("Could not find $entityType with ID $id")