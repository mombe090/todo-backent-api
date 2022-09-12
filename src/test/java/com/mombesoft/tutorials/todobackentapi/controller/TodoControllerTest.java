package com.mombesoft.tutorials.todobackentapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mombesoft.tutorials.todobackentapi.collections.TodoCollection;
import com.mombesoft.tutorials.todobackentapi.dto.TodoDto;
import com.mombesoft.tutorials.todobackentapi.repository.TodoRepository;
import com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl;
import com.mombesoft.tutorials.todobackentapi.utils.MessageModel;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = { TodoController.class })
@ExtendWith(SpringExtension.class)
class TodoControllerTest {

    @Autowired
    private TodoController todoController;

    @MockBean
    private TodoSvcImpl todoSvcImpl;

    /**
     * Method under test: {@link TodoController#todo(String)}
     */
    @Test
    void testTodo() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.HashMap["data"]->com.mombesoft.tutorials.todobackentapi.collections.TodoCollection$MockitoMock$43LdSj3P["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["serializationSupport"])
        //       at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:462)
        //       at org.springframework.http.converter.AbstractGenericHttpMessageConverter.write(AbstractGenericHttpMessageConverter.java:104)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:290)
        //       at org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor.handleReturnValue(HttpEntityMethodProcessor.java:219)
        //       at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:78)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:135)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent todo(String)
        //   from throwing HttpMessageConversionException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   todo(String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.findById((String) any())).thenReturn(Optional.of(mock(TodoCollection.class)));
        ResponseEntity<Object> actualTodoResult = (new TodoController(new TodoSvcImpl(todoRepository))).todo("42");
        assertEquals(2, ((Map<String, Object>) actualTodoResult.getBody()).size());
        assertTrue(actualTodoResult.hasBody());
        assertTrue(actualTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualTodoResult.getStatusCode());
        verify(todoRepository).findById((String) any());
    }

    /**
     * Method under test: {@link TodoController#todo(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTodo2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.HashMap["data"]->com.mombesoft.tutorials.todobackentapi.collections.TodoCollection$MockitoMock$43LdSj3P["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["serializationSupport"])
        //       at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:462)
        //       at org.springframework.http.converter.AbstractGenericHttpMessageConverter.write(AbstractGenericHttpMessageConverter.java:104)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:290)
        //       at org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor.handleReturnValue(HttpEntityMethodProcessor.java:219)
        //       at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:78)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:135)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent todo(String)
        //   from throwing HttpMessageConversionException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   todo(String).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElse(Object)" because the return value of "com.mombesoft.tutorials.todobackentapi.repository.TodoRepository.findById(Object)" is null
        //       at com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl.getTodo(TodoSvcImpl.java:24)
        //       at com.mombesoft.tutorials.todobackentapi.controller.TodoController.todo(TodoController.java:33)
        //   In order to prevent todo(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   todo(String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.findById((String) any())).thenReturn(null);
        (new TodoController(new TodoSvcImpl(todoRepository))).todo("42");
    }

    /**
     * Method under test: {@link TodoController#todo(String)}
     */
    @Test
    void testTodo3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.HashMap["data"]->com.mombesoft.tutorials.todobackentapi.collections.TodoCollection$MockitoMock$43LdSj3P["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["serializationSupport"])
        //       at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:462)
        //       at org.springframework.http.converter.AbstractGenericHttpMessageConverter.write(AbstractGenericHttpMessageConverter.java:104)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:290)
        //       at org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor.handleReturnValue(HttpEntityMethodProcessor.java:219)
        //       at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:78)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:135)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent todo(String)
        //   from throwing HttpMessageConversionException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   todo(String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.findById((String) any())).thenReturn(Optional.empty());
        ResponseEntity<Object> actualTodoResult = (new TodoController(new TodoSvcImpl(todoRepository))).todo("42");
        assertEquals(2, ((Map<String, Object>) actualTodoResult.getBody()).size());
        assertTrue(actualTodoResult.hasBody());
        assertTrue(actualTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualTodoResult.getStatusCode());
        MessageModel getResult = ((List<MessageModel>) ((Map<String, Object>) actualTodoResult.getBody()).get("message"))
                .get(0);
        assertEquals("The todo with 42 now exist", getResult.getDescription());
        assertEquals("TODO NOT FOUND", getResult.getTitle());
        verify(todoRepository).findById((String) any());
    }

    /**
     * Method under test: {@link TodoController#todo(String)}
     */
    @Test
    void testTodo4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.HashMap["data"]->com.mombesoft.tutorials.todobackentapi.collections.TodoCollection$MockitoMock$43LdSj3P["mockitoInterceptor"]->org.mockito.internal.creation.bytebuddy.MockMethodInterceptor["serializationSupport"])
        //       at org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.writeInternal(AbstractJackson2HttpMessageConverter.java:462)
        //       at org.springframework.http.converter.AbstractGenericHttpMessageConverter.write(AbstractGenericHttpMessageConverter.java:104)
        //       at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:290)
        //       at org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor.handleReturnValue(HttpEntityMethodProcessor.java:219)
        //       at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:78)
        //       at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:135)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)
        //       at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
        //       at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1070)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:199)
        //   In order to prevent todo(String)
        //   from throwing HttpMessageConversionException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   todo(String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoSvcImpl todoSvcImpl = mock(TodoSvcImpl.class);
        when(todoSvcImpl.getTodo((String) any())).thenReturn(mock(TodoCollection.class));
        ResponseEntity<Object> actualTodoResult = (new TodoController(todoSvcImpl)).todo("42");
        assertEquals(2, ((Map<String, Object>) actualTodoResult.getBody()).size());
        assertTrue(actualTodoResult.hasBody());
        assertTrue(actualTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualTodoResult.getStatusCode());
        verify(todoSvcImpl).getTodo((String) any());
    }

    /**
     * Method under test: {@link TodoController#createTodo(TodoDto)}
     */
    @Test
    void testCreateTodo() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.getTitle()).thenReturn("Dr");
        ResponseEntity<Object> actualCreateTodoResult = todoController.createTodo(todoDto);
        assertEquals(2, ((Map<String, Object>) actualCreateTodoResult.getBody()).size());
        assertTrue(actualCreateTodoResult.hasBody());
        assertTrue(actualCreateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualCreateTodoResult.getStatusCode());
        verify(todoRepository).save((TodoCollection) any());
        verify(todoDto).getTitle();
    }

    /**
     * Method under test: {@link TodoController#createTodo(TodoDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateTodo2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl.createTodo(com.mombesoft.tutorials.todobackentapi.dto.TodoDto)" because "this.todoSvc" is null
        //       at com.mombesoft.tutorials.todobackentapi.controller.TodoController.createTodo(TodoController.java:51)
        //   In order to prevent createTodo(TodoDto)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createTodo(TodoDto).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoController todoController = new TodoController(null);
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.getTitle()).thenReturn("Dr");
        todoController.createTodo(todoDto);
    }

    /**
     * Method under test: {@link TodoController#createTodo(TodoDto)}
     */
    @Test
    void testCreateTodo3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoSvcImpl todoSvcImpl = mock(TodoSvcImpl.class);
        when(todoSvcImpl.createTodo((TodoDto) any())).thenReturn(mock(TodoCollection.class));
        TodoController todoController = new TodoController(todoSvcImpl);
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.getTitle()).thenReturn("Dr");
        ResponseEntity<Object> actualCreateTodoResult = todoController.createTodo(todoDto);
        assertEquals(2, ((Map<String, Object>) actualCreateTodoResult.getBody()).size());
        assertTrue(actualCreateTodoResult.hasBody());
        assertTrue(actualCreateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualCreateTodoResult.getStatusCode());
        verify(todoSvcImpl).createTodo((TodoDto) any());
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    void testUpdateTodo() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoCollection todoCollection = mock(TodoCollection.class);
        doNothing().when(todoCollection).setStatus(anyBoolean());
        doNothing().when(todoCollection).setTitle((String) any());
        Optional<TodoCollection> ofResult = Optional.of(todoCollection);
        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        when(todoRepository.findById((String) any())).thenReturn(ofResult);
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn("Dr");
        ResponseEntity<Object> actualUpdateTodoResult = todoController.updateTodo(todoDto, "42");
        assertEquals(2, ((Map<String, Object>) actualUpdateTodoResult.getBody()).size());
        assertTrue(actualUpdateTodoResult.hasBody());
        assertTrue(actualUpdateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualUpdateTodoResult.getStatusCode());
        verify(todoRepository).save((TodoCollection) any());
        verify(todoRepository).findById((String) any());
        verify(todoCollection).setStatus(anyBoolean());
        verify(todoCollection).setTitle((String) any());
        verify(todoDto).isStatus();
        verify(todoDto, atLeast(1)).getTitle();
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateTodo2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElse(Object)" because the return value of "com.mombesoft.tutorials.todobackentapi.repository.TodoRepository.findById(Object)" is null
        //       at com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl.updateTodo(TodoSvcImpl.java:39)
        //       at com.mombesoft.tutorials.todobackentapi.controller.TodoController.updateTodo(TodoController.java:58)
        //   In order to prevent updateTodo(TodoDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateTodo(TodoDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        when(todoRepository.findById((String) any())).thenReturn(null);
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn("Dr");
        todoController.updateTodo(todoDto, "42");
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    void testUpdateTodo3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        when(todoRepository.findById((String) any())).thenReturn(Optional.empty());
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn("Dr");
        ResponseEntity<Object> actualUpdateTodoResult = todoController.updateTodo(todoDto, "42");
        assertEquals(2, ((Map<String, Object>) actualUpdateTodoResult.getBody()).size());
        assertTrue(actualUpdateTodoResult.hasBody());
        assertTrue(actualUpdateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.NOT_FOUND, actualUpdateTodoResult.getStatusCode());
        MessageModel getResult = ((List<MessageModel>) ((Map<String, Object>) actualUpdateTodoResult.getBody())
                .get("message")).get(0);
        assertEquals("The todo with 42 now exist", getResult.getDescription());
        assertEquals("TODO NOT FOUND", getResult.getTitle());
        verify(todoRepository).findById((String) any());
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    void testUpdateTodo4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoCollection todoCollection = mock(TodoCollection.class);
        doNothing().when(todoCollection).setStatus(anyBoolean());
        doNothing().when(todoCollection).setTitle((String) any());
        Optional.of(todoCollection);
        TodoSvcImpl todoSvcImpl = mock(TodoSvcImpl.class);
        when(todoSvcImpl.updateTodo((String) any(), (TodoDto) any())).thenReturn(mock(TodoCollection.class));
        TodoController todoController = new TodoController(todoSvcImpl);
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn("Dr");
        ResponseEntity<Object> actualUpdateTodoResult = todoController.updateTodo(todoDto, "42");
        assertEquals(2, ((Map<String, Object>) actualUpdateTodoResult.getBody()).size());
        assertTrue(actualUpdateTodoResult.hasBody());
        assertTrue(actualUpdateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualUpdateTodoResult.getStatusCode());
        verify(todoSvcImpl).updateTodo((String) any(), (TodoDto) any());
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateTodo5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.isEmpty()" because the return value of "com.mombesoft.tutorials.todobackentapi.dto.TodoDto.getTitle()" is null
        //       at com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl.updateTodo(TodoSvcImpl.java:42)
        //       at com.mombesoft.tutorials.todobackentapi.controller.TodoController.updateTodo(TodoController.java:58)
        //   In order to prevent updateTodo(TodoDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateTodo(TodoDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoCollection todoCollection = mock(TodoCollection.class);
        doNothing().when(todoCollection).setStatus(anyBoolean());
        doNothing().when(todoCollection).setTitle((String) any());
        Optional<TodoCollection> ofResult = Optional.of(todoCollection);
        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        when(todoRepository.findById((String) any())).thenReturn(ofResult);
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn(null);
        todoController.updateTodo(todoDto, "42");
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    void testUpdateTodo6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        TodoCollection todoCollection = mock(TodoCollection.class);
        doNothing().when(todoCollection).setStatus(anyBoolean());
        doNothing().when(todoCollection).setTitle((String) any());
        Optional<TodoCollection> ofResult = Optional.of(todoCollection);
        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.save((TodoCollection) any())).thenReturn(mock(TodoCollection.class));
        when(todoRepository.findById((String) any())).thenReturn(ofResult);
        TodoController todoController = new TodoController(new TodoSvcImpl(todoRepository));
        TodoDto todoDto = mock(TodoDto.class);
        when(todoDto.isStatus()).thenReturn(true);
        when(todoDto.getTitle()).thenReturn("");
        ResponseEntity<Object> actualUpdateTodoResult = todoController.updateTodo(todoDto, "42");
        assertEquals(2, ((Map<String, Object>) actualUpdateTodoResult.getBody()).size());
        assertTrue(actualUpdateTodoResult.hasBody());
        assertTrue(actualUpdateTodoResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.ACCEPTED, actualUpdateTodoResult.getStatusCode());
        verify(todoRepository).save((TodoCollection) any());
        verify(todoRepository).findById((String) any());
        verify(todoCollection).setStatus(anyBoolean());
        verify(todoDto).isStatus();
        verify(todoDto).getTitle();
    }

    /**
     * Method under test: {@link TodoController#updateTodo(TodoDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateTodo7() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of TodoController.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.mombesoft.tutorials.todobackentapi.dto.TodoDto.getTitle()" because "todo" is null
        //       at com.mombesoft.tutorials.todobackentapi.services.impl.TodoSvcImpl.updateTodo(TodoSvcImpl.java:42)
        //       at com.mombesoft.tutorials.todobackentapi.controller.TodoController.updateTodo(TodoController.java:58)
        //   In order to prevent updateTodo(TodoDto, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateTodo(TodoDto, String).
        //   See https://diff.blue/R013 to resolve this issue.

        TodoRepository todoRepository = mock(TodoRepository.class);
        when(todoRepository.findById((String) any())).thenReturn(Optional.of(mock(TodoCollection.class)));
        (new TodoController(new TodoSvcImpl(todoRepository))).updateTodo(null, "foo");
    }

    /**
     * Method under test: {@link TodoController#deleteTodo(String)}
     */
    @Test
    void testDeleteTodo() throws Exception {
        when(todoSvcImpl.deleteTodo((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(todoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":204}"));
    }

    /**
     * Method under test: {@link TodoController#deleteTodo(String)}
     */
    @Test
    void testDeleteTodo2() throws Exception {
        when(todoSvcImpl.deleteTodo((String) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", "42");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(todoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":[{\"title\":\"TODO NOT FOUND\",\"description\":\"The todo with 42 now exist\"}],\"statusCode\":404}"));
    }

    /**
     * Method under test: {@link TodoController#deleteTodo(String)}
     */
    @Test
    void testDeleteTodo3() throws Exception {
        doNothing().when(todoSvcImpl).deleteAllTodos();
        when(todoSvcImpl.deleteTodo((String) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", "", "Uri Variables");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(todoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":204}"));
    }

    /**
     * Method under test: {@link TodoController#deleteAll()}
     */
    @Test
    void testDeleteAll() throws Exception {
        when(todoSvcImpl.getAllTodos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(todoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"data\":[],\"statusCode\":200}"));
    }

    /**
     * Method under test: {@link TodoController#deleteAll()}
     */
    @Test
    void testDeleteAll2() throws Exception {
        when(todoSvcImpl.getAllTodos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(todoController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"data\":[],\"statusCode\":200}"));
    }
}

