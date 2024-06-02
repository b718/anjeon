import { Analysis } from "@/utils/Types";
import React, { FunctionComponent } from "react";

type RenderAnalysis = {
  analysisList: Analysis[];
};

const RenderAnalysis: FunctionComponent<RenderAnalysis> = ({
  analysisList,
}) => {
  return (
    <div className="mt-5 font-sans m-4">
      <p className="flex flex-col justify-center m-[1rem]">
        The 1st column is % of bullying, and the 2nd column is % of not bullying
      </p>
      {analysisList.map((analysis) => {
        return (
          <div key={analysis.name}>
            <p className="mt-5">{analysis.name}</p>
            <div className="mt-2">
              {analysis.analysisTextList.map((analysisText) => {
                return (
                  <div className="flex flex-row items-start justify-between">
                    <p className=" max-w-[25rem]">{analysisText.text}</p>
                    <div className="flex flex-row">
                      <p className="pr-5 min-w-5">
                        {analysisText.bullying_probability}
                      </p>
                      <p className="min-w-5">
                        {analysisText.not_bullying_probability}
                      </p>
                    </div>
                  </div>
                );
              })}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default RenderAnalysis;
