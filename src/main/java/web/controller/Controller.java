package web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import web.entity.*;
import web.exeptions.ControllerExeption;
import web.exeptions.UserAlreadyExistsExeption;
import web.repository.*;
import web.service.UserService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private
    TimeTableRepository timeTableRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addTimeTable(@RequestBody TimeTableDTO timeTableDto) {
        timeTableRepository.addTimeTable(timeTableDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public org.springframework.web.servlet.ModelAndView getTimeTable(@RequestParam Integer groupId) {
        ModelAndView modelAndView = new ModelAndView("viewTimeTable");

        /*TimeTableDTO timeTableDto = timeTableRepository.selectTimeTable();
        Map<String, List<Lesson>> mapOfLessons = new HashMap<>();

        List<Lesson> lessons = timeTableDto.getMondayLessons();
        mapOfLessons.put("mondayLessons", lessons);

        lessons = timeTableDto.getTuesdayLessons();
        mapOfLessons.put("tuesdayLessons", lessons);

        lessons = timeTableDto.getWednesdayLessons();
        mapOfLessons.put("wednesdayLessons", lessons);

        lessons = timeTableDto.getThursdayLessons();
        mapOfLessons.put("thursdayLessons", lessons);

        lessons = timeTableDto.getFridayLessons();
        mapOfLessons.put("fridayLessons", lessons);

        Date dateStart = timeTableDto.getCurrentMondayDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateEnd = calendar.getTime();

        modelAndView.addObject("currentDate", dateStart + " - " + simpleDateFormat.format(dateEnd));
        modelAndView.addAllObjects(mapOfLessons);*/

        return modelAndView;
    }

    @RequestMapping(value = "/alter", method = RequestMethod.POST)
    public ResponseEntity updateTimeTable(@RequestBody TimeTableDTO timeTableDto) {
        timeTableRepository.updateTimeTable(timeTableDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Autowired
    private UniversitiesRepository universitiesRepository;
    @Autowired
    private FacultiesRepository facultiesRepository;
    @Autowired
    private SpecialitiesRepository specialitiesRepository;
    @Autowired
    private GroupsRepository groupsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView startPage() {
        ModelAndView model = new ModelAndView("startPage");
        List<String> allUniversities = universitiesRepository.getAllUniversities();
        model.addObject("allUniversities", allUniversities);

        return model;
    }

    @RequestMapping(value = "/getFaculties", method = RequestMethod.POST)
    @ResponseBody
    public FacultiesAndUnivIdDTO getFaculties(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UniversityNameDTO universityNameDTO = mapper.readValue(params, UniversityNameDTO.class);
        Integer universityId = facultiesRepository.getUniversityId(universityNameDTO.getUniversityName());
        List<String> faculties = facultiesRepository.getAllFacultiesOfCurrentUniversity(universityId);
        return new FacultiesAndUnivIdDTO(universityId, faculties);
    }

    @RequestMapping(value = "/getSpecialities", method = RequestMethod.POST)
    @ResponseBody
    public SpecialitiesAndFacIdDTO getSpecialities(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FacultyNameDTO facultyNameDTO = mapper.readValue(String.valueOf(params), FacultyNameDTO.class);
        Integer facultyId = specialitiesRepository.getFacultyId(facultyNameDTO.getUniversityId(), facultyNameDTO.getFacultyName());
        List<String> specialitiesNames = specialitiesRepository.getAllSpecialitiesOfCurrentFaculty(facultyId);
        return new SpecialitiesAndFacIdDTO(facultyId, specialitiesNames);
    }

    @RequestMapping(value = "/getGroups", method = RequestMethod.POST)
    @ResponseBody
    public GroupsAndSpecIdDTO getGroups(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SpecialityNameDTO specialityNameDTO = mapper.readValue(String.valueOf(params), SpecialityNameDTO.class);
        Integer specialityId = groupsRepository.getSpecialityId(specialityNameDTO.getFacultyId(), specialityNameDTO.getSpecialityName());
        List<String> groupsNames = groupsRepository.getAllGroupsOfCurrentSpeciality(specialityId);
        return new GroupsAndSpecIdDTO(specialityId, groupsNames);
    }

    @RequestMapping(value = "/getGroupId", method = RequestMethod.POST)
    @ResponseBody
    public Integer getGroupId(@RequestBody String params) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GroupNameAndSpecIdDTO groupNameAndSpecIdDTO = mapper.readValue(String.valueOf(params), GroupNameAndSpecIdDTO.class);
        return groupsRepository.getGroupId(groupNameAndSpecIdDTO.getGroupName(), groupNameAndSpecIdDTO.getSpecialityId());
    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public ResponseEntity sendEmail(@RequestBody EmailDTO emailDTO) {
        System.out.println("emailDTO = " + emailDTO);
        String email = emailDTO.getEmail();
        try {
            userService.sendAndSaveAccount(email);
        } catch (UserAlreadyExistsExeption userAlreadyExistsExeption) {
            userAlreadyExistsExeption.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EmailException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Не удалось отправить письмо", e);
        } catch (RuntimeException r) {
            r.printStackTrace();
            throw new ControllerExeption();
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/signInSignUp", method = RequestMethod.GET)
    public ModelAndView signInSignUp() {
        return new ModelAndView("signInSignUp");
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public UserExistsDTO checkUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.toString());
        boolean isExist = userService.checkUser(userDTO.getLogin(), userDTO.getPassword());
        return new UserExistsDTO(userDTO.getLogin(), isExist);
    }

    @RequestMapping(value = "/mainWithTimeTables", method = RequestMethod.GET)
    public ModelAndView mainWithTimeTables(@RequestParam String login) {
        System.out.println("login = " + login);
        List<Integer> groupIdByUserName = userRepository.getGroupIdByUserName(login);
        List<TimeTableDTO> timeTableDTOS = timeTableRepository.selectTimeTable(groupIdByUserName);
        ModelAndView modelAndView = new ModelAndView();
        return new ModelAndView("index");
    }

    @ExceptionHandler(ControllerExeption.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Ошибка при отправке письма")
    public void handleException(ControllerExeption ex) {
        System.out.println("ex = " + ex);
    }
}