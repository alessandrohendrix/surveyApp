package com.surveyapp.survey.repository.survey;

import com.surveyapp.survey.domain.entities.survey.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer> {


    /**
     * Find most recent published Survey for a product
     * @param pageable
     * @return
     */
    @Query("SELECT s FROM Survey s WHERE s.product.ID=:productId ORDER BY s.ID DESC")
    Page<Survey> findMostRecentSurvey(
            @Param("productId") Integer productID,
            Pageable pageable
    );

    @Query("SELECT s FROM Survey s WHERE s.product.ID=:productId AND s.published = true ORDER BY s.ID DESC")
    Page<Survey> findLastPublishedSurvey(@Param("productId") Integer productID, Pageable pageable);

    /**
     * Select a product Survey based on creation date
     * @param productID
     * @param creationDate
     * @return
     */
    @Query("SELECT s FROM Survey s WHERE s.product.ID =:productId AND s.creationDate =:creationDate AND s.published=true")
    Optional<Survey> findByCreationDateAndProductID(
            @Param("productId") Integer productID,
            @Param("creationDate") LocalDateTime creationDate
    );

    /**
     * Get all published surveys related to a product
     * @param productID
     * @return
     */
    @Query("SELECT s.creationDate, s.ID FROM Survey s WHERE s.product.ID =:productId AND s.published = true")
    List<Survey> findCreationDates(@Param("productId") Integer productID);

}
