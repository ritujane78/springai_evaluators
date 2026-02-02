# Evaluators for Testing AI Responses

## Overview
This project focuses on testing and validating AI-generated responses using built-in evaluators. The goal is to ensure that responses are both **relevant** to the query and **factually correct**, improving overall reliability and user experience.

## AI Models Used
This project leverages two different AI models, each with a specific responsibility:

- **llama3.2:3b**  
  Used for generating AI responses to user queries.

- **bespoke-minicheck**  
  Used by evaluators to verify that the generated responses are correct, relevant, and factually accurate.

## Evaluators Used
The following evaluators are utilized in this project:

- **RelevancyEvaluator**  
  Ensures that the AI response is relevant to the user’s query and stays within the expected context.

- **FactCheckingEvaluator**  
  Verifies the factual accuracy of the AI-generated response.

## Custom Error Handling
In cases where:
- the AI does not return a response, or
- the response fails relevancy or fact-checking evaluation,

a **custom fallback message** is returned to the user. This helps maintain clarity and provides a better user experience instead of exposing incomplete or incorrect AI output.

## Purpose
- Improve AI response quality
- Automatically validate relevance and correctness
- Provide meaningful feedback to users when responses fail evaluation
