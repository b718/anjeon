"use client";
import { Avatar, TextareaAutosize } from "@mui/material";
import InputIcon from "@mui/icons-material/Input";
import React, { useEffect, useState } from "react";

const AnjeonHomepage = () => {
  const [userNamesInput, setUserNamesInput] = useState<string>("");
  const [userTextInput, setUserTextInput] = useState<string>("");

  const sendUserInput = async (e: any) => {
    e.preventDefault();

    const userObject = {
      userNames: userNamesInput,
      userText: userTextInput,
    };

    const sendRequest = await fetch("http://localhost:5000/api/v1/analyze", {
      method: "POST",
      body: JSON.stringify(userObject),
      headers: {
        "Content-Type": "application/json",
      },
    });

    setUserNamesInput("");
    setUserTextInput("");
  };

  return (
    <main className="flex flex-col items-center text-black h-svh bg-gradient-to-r from-indigo-100 to-transparent">
      <div className="flex flex-col items-center mt-10">
        <text className="font-sans text-3xl font-light"> anjeon </text>

        <text className="flex flex-col items-center font-sans text-lg font-light mt-[10vh] ml-2 mr-2 xs:text-center md:text-justify">
          analyze conversations with anjeon, and understand the intent in
          minutes
        </text>

        <div
          className="flex flex-row items-end p-2 border-slate-400 
          rounded-2xl border-2 bg-white mt-[30vh]"
        >
          <TextareaAutosize
            className="focus:outline-none font-sans min-w-[10vw] resize-none text-xs border-r-2"
            placeholder="Names of users .."
            minRows={1}
            value={userNamesInput}
            onChange={(e) => setUserNamesInput(e.target.value)}
          />
          <TextareaAutosize
            className="focus:outline-none font-sans min-w-[20vw] resize-none text-xs pl-1"
            placeholder="Text to analyze .."
            minRows={1}
            value={userTextInput}
            onChange={(e) => setUserTextInput(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && sendUserInput(e)}
          />

          <InputIcon
            className={`font-sans ${
              userTextInput.length > 0 ? " text-slate-900" : "text-slate-400"
            } text-base`}
          />
        </div>
      </div>
    </main>
  );
};

export default AnjeonHomepage;
