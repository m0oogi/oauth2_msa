package com.example.oauth.member.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.oauth.member.Member;

@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {}
