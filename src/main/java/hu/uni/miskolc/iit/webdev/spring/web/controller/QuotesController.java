package hu.uni.miskolc.iit.webdev.spring.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Istvan Berzi on 2018.12.02
 */
@Controller
public class QuotesController {

	private static final List<String> idezetek = Arrays.asList(
			"\"A nagy emberek eszmékről beszélnek, az átlagos emberek dolgokról, a kis emberek pedig más emberekről.\" (Eleanor Roosevelt)", 
			"\"Aki harcol, veszíthet. Aki nem harcol, már vesztett is.\" (Bertolt Brecht)",
			"\"Két módon tehetnek bolonddá. Az egyik, hogy elhitetik veled a hazugságot. "+ 
			"A másik, hogy visszautasítod az igazságot.\" (Søren Kierkegaard)",
			"\"Az élet 10%-a, ami veled történik, és 90%-a, ahogyan reagálsz a történésekre.\" (John C. Maxwell)",
			"\"Nem az a szegény, akinek csak kevese van, hanem aki többre vágyik.\" (Seneca)",
			"\"Nem lehet összekötni a pontokat a jövőt fürkészve, az összefüggések csak utólag visszanézve látszanak.\" (Steve Jobs)",
			"\"Minden bajra két orvosság van: az idő és a csend.\" (Alexandre Dumas)",
			"\"Az elme önmagában képes a Poklot Mennyé, a Mennyet Pokollá változtatni.\" (John Milton)",
			"\"Fájdalmas a vereség, de még fájdalmasabb, ha nem a legjobb formádat adtad!\" (Andrew Matthews – Élj Vidáman)",
			"\"Úgy álljunk meg az életben, akár a sziklaszírt a tengerben; ne engedjük, hogy a szüntelen hullámverés megingasson bennünket.\" (Hazrat Inajat Khan)");
	
	private static final Random randomGenerator = new Random();
	
	@RequestMapping(value = "/random", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String random(){
		
		int randomId = randomGenerator.nextInt(idezetek.size());
        return idezetek.get(randomId);
    }
	
	@RequestMapping(value = "/select", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String select(@RequestParam(value = "id", required = true) int id){
        if(id >= 0 && id < idezetek.size()){
            return idezetek.get(id);
        }
        return "Nem létezik ilyen sorszámú idézet!";
    }
	
	@RequestMapping(value = "/list", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String list(){
		StringBuilder s = new StringBuilder();
		for (String listElement : idezetek) {
			s.append(listElement + "\n");
		}
		return s.toString();
    }
	
	@ExceptionHandler(value={NumberFormatException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String handleNumberFormatException(){
        return "A paraméter nem egész szám!";
    }
}
