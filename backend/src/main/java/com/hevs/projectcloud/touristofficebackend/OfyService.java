package com.hevs.projectcloud.touristofficebackend;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.hevs.projectcloud.touristofficebackend.models.Activity;
import com.hevs.projectcloud.touristofficebackend.models.Answer;
import com.hevs.projectcloud.touristofficebackend.models.Category;
import com.hevs.projectcloud.touristofficebackend.models.Feedback;
import com.hevs.projectcloud.touristofficebackend.models.Language;
import com.hevs.projectcloud.touristofficebackend.models.Locale;
import com.hevs.projectcloud.touristofficebackend.models.Possibility;
import com.hevs.projectcloud.touristofficebackend.models.Question;
import com.hevs.projectcloud.touristofficebackend.models.Questionnaire;
import com.hevs.projectcloud.touristofficebackend.models.Recommendation;

/**
 *
 * Created by lukas_000 on 11.07.2015.
 * Refering to Google's tutorial on
 * https://cloud.google.com/solutions/mobile/
 * how-to-build-mobile-app-with-app-engine-backend-tutorial/
 *
 * Objectify service wrapper so we can statically register our persistence
 * classes.
 * More on Objectify here : https://code.google.com/p/objectify-appengine/
 */
public class OfyService {

    /**
     * Default constructor, never called.
     */
    private OfyService() { }

    static {
        ObjectifyService.register(RegistrationRecord.class);
        factory().register(Activity.class);
        factory().register(Answer.class);
        factory().register(Category.class);
        factory().register(Feedback.class);
        factory().register(Language.class);
        factory().register(Locale.class);
        factory().register(Possibility.class);
        factory().register(Question.class);
        factory().register(Questionnaire.class);
        factory().register(Recommendation.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
