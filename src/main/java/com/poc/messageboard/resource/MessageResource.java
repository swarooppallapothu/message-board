package com.poc.messageboard.resource;

import com.poc.messageboard.dto.Response;
import com.poc.messageboard.model.Message;
import com.poc.messageboard.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@RestController
@RequestMapping(value = "/api/message")
public class MessageResource extends AbstractResource<Message> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MessageService messageService;

    public MessageResource(MessageService messageService) {
        super(messageService);
        this.messageService = messageService;
    }

    @GetMapping("/search")
    public ResponseEntity<Response<List<Message>>> search(@RequestParam(name = "userId", required = true) UUID userId) {
        try {
            return ResponseEntity.ok(Response.<List<Message>>builder().result(Response.ResultCode.SUCCESS).data(messageService.getByCreatedUser(userId)).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method search with id:" + userId, e);
            return ResponseEntity.badRequest().body(Response.<List<Message>>builder().result(Response.ResultCode.ERROR).build());
        }
    }
}
