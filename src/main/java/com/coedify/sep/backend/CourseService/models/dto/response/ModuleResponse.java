package com.coedify.sep.backend.CourseService.models.dto.response;

import java.util.List;

import com.coedify.sep.backend.CourseService.models.pojo.Module;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
public class ModuleResponse extends Module {
         List<TopicResponse> topicList;
}
