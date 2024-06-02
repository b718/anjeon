"use client";
import { CircularProgress, TextareaAutosize } from "@mui/material";
import InputIcon from "@mui/icons-material/Input";
import React, { useEffect, useState } from "react";
import "./AnjeonHomepage.css";
import { AnalysisText } from "@/utils/Types";
import RenderAnalysis from "./(utils)/page";

const AnjeonHomepage = () => {
  const [userTextInput, setUserTextInput] = useState<string>("");
  const [responseProbability, setResponseProbability] = useState<
    AnalysisText[]
  >([]);
  const [isLoaded, setIsLoaded] = useState<string>("");

  const sendUserInput = async (e: any) => {
    e.preventDefault();

    const userObject = {
      text: userTextInput,
    };

    console.log(userObject);
    setIsLoaded("loading");
    const sendRequest = await fetch("http://localhost:8080/analyze-data", {
      method: "POST",
      body: JSON.stringify(userObject),
      headers: {
        "Content-Type": "application/json",
      },
    }).then(async (response) => {
      const result = await response.json();
      setResponseProbability((responseProbability) => [
        ...responseProbability,
        result.analysisText,
      ]);
      setIsLoaded("loaded");
    });

    setUserTextInput("");
  };

  useEffect(() => {
    console.log(responseProbability);
  }, [responseProbability]);

  return (
    <main className="flex flex-col items-center text-white pb-5">
      <div className="flex flex-col items-center mt-10">
        <text className="font-sans text-3xl font-light"> anjeon </text>

        <text className="flex flex-col items-center font-sans text-lg font-light mt-[10vh] ml-2 mr-2 xs:text-center md:text-justify">
          analyze conversations with anjeon, and understand the intent in
          minutes
        </text>

        <div
          className="flex flex-row items-end p-2 border-neutral-400 
          rounded-2xl border-2  bg-neutral-900 mt-[30vh]"
        >
          <TextareaAutosize
            className="anjeonHompageScrollBar focus:outline-none font-sans min-w-[20vw] resize-none text-xs pl-1 scroll-b"
            placeholder="Text to analyze .."
            minRows={1}
            maxRows={12}
            value={userTextInput}
            onChange={(e) => setUserTextInput(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && sendUserInput(e)}
          />

          <InputIcon
            className={`font-sans transition ${
              userTextInput.length > 0
                ? " text-neutral-400"
                : "text-neutral-800"
            } text-base`}
          />
        </div>
      </div>

      {responseProbability &&
      responseProbability.length > 0 &&
      isLoaded === "loaded" ? (
        <RenderAnalysis analysisTextList={responseProbability} />
      ) : (
        isLoaded === "loading" && (
          <CircularProgress className="mt-5 text-white" />
        )
      )}
    </main>
  );
};

export default AnjeonHomepage;
