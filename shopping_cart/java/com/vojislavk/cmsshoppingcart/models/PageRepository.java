package com.vojislavk.cmsshoppingcart.models;

import java.util.List;

import com.vojislavk.cmsshoppingcart.models.data.Page;

import org.springframework.data.jpa.repository.JpaRepository;

// "Integer" since the Page id is an int
public interface PageRepository extends JpaRepository<Page, Integer> {

    Page findBySlug(String slug); // looks for a field named "slug" in Page

    // @Query("SELECT p FROM Page p WHERE p.id != :id and p.slug = :slug")
    // Page findBySlug(int id, String slug);

    Page findBySlugAndIdNot(String slug, int id);

    List<Page> findAllByOrderBySortingAsc();

}