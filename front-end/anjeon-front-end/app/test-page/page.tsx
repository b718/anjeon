import { Metadata } from "next";
import Head from "next/head";
import React from "react";

export const metadata: Metadata = {
  title: "testing this page",
  description: "",
};

const page = () => {
  return (
    <div>
      <Head>
        <title>this must change</title>
        <meta name="viewport" content="initial-scale=1, width=device-width" />
      </Head>

      <div>Testing this part</div>
    </div>
  );
};

export default page;
