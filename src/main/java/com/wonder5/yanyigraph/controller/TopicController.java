package com.wonder5.yanyigraph.controller;

import com.wonder5.yanyigraph.dto.Topic;
import com.wonder5.yanyigraph.service.TopicService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author yuhaoy
 */

@RestController
public class TopicController {

    /**
     * Dependency inject the topic service
     */
    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of Topics", notes = "Returns the list of Topics", response = Topic.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of the list of Topics", response = Topic.class, responseContainer = "List")})
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topic/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the topic with certain id", notes = "Returns the list of Topics", response = Topic.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval of the list of Topics", response = Topic.class)})
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    /**
     * POST: For creating!!!
     *
     * @param topic
     */
    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    @ApiOperation(value = "Create a new topic")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful creation of new topic")})
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    /**
     * PUT: For updating!!
     *
     * @param topic
     * @param id
     */
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update the old topic with new topic")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful update of old topic")})
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }
}
