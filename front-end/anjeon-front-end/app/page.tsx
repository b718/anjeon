import { Avatar, TextareaAutosize } from "@mui/material";
import InputIcon from "@mui/icons-material/Input";
import React from "react";

const AnjeonHomepage = () => {
  return (
    <main className="flex flex-col items-center text-black h-svh bg-gradient-to-r from-indigo-100 to-transparent">
      <div className="flex flex-col items-center mt-10">
        <text className="font-sans text-3xl font-light"> anjeon </text>

        <text className="flex flex-col items-center font-sans text-lg font-light mt-[10vh] ml-2 mr-2">
          analyze conversations with anjeon, and understand the intent in
          minutes
        </text>

        <div
          className="flex flex-row items-end p-2 border-slate-400 
          rounded-2xl border-2 bg-white mt-[30vh]"
        >
          <TextareaAutosize
            className="focus:outline-none font-sans min-w-[20vw] resize-none"
            placeholder="Analyze with anjeon .."
            minRows={1}
          />
          <InputIcon className="font-sans text-slate-400" />
        </div>
      </div>
    </main>
  );
};

export default AnjeonHomepage;
