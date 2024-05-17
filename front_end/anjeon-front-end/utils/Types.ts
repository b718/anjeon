export type AnalysisText = {
  bullying_probability: string;
  not_bullying_probability: string;
  text: string;
};

export type Analysis = {
  name: string;
  analysisTextList: AnalysisText[];
};
