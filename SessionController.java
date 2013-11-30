package guest;
 
import java.sql.Date;
import java.sql.Time;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SessionController {
 
    @Autowired
    private SessionDao SessionDao;
 
    @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        String lessonDate = request.getParameter("lessonDate");
        String lessonTime = request.getParameter("lessonTime");
        String lessonDuration= request.getParameter("lessonDuration");
        String repeatFreq = request.getParameter("repeatFreq");
        String lecName = request.getParameter("lecName");
        String maxAttendance = request.getParameter("maxAttendance");
        String compulsory = request.getParameter("compulsory");
        String venue = request.getParameter("venue");
        
        
        if (name != null){
            SessionDao.persist(new Session(name, lessonDate, lessonTime, lessonDuration, repeatFreq, lecName, maxAttendance, compulsory, venue));
            /*SessionDao.persist(new Session(lessonDate));
            SessionDao.persist(new Session(lessonTime));
            SessionDao.persist(new Session(lessonDuration));
            SessionDao.persist(new Session(repeatFreq));
            SessionDao.persist(new Session(lecName));
            SessionDao.persist(new Session(maxAttendance));
            SessionDao.persist(new Session(compulsory));
            SessionDao.persist(new Session(venue));*/
        }
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "SessionDao", SessionDao);
    }
}