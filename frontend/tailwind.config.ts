import { fontFamily } from "tailwindcss/defaultTheme";
import type { Config } from "tailwindcss";

const config: Config = {
    darkMode: ["class"],
    content: ["./src/**/*.{html,js,svelte,ts}"],
    safelist: ["dark"],
    theme: {
        container: {
            center: true,
            padding: "2rem",
            screens: {
                "2xl": "1400px"
            }
        },
        extend: {
            colors: {
                border: "hsl(var(--border) / <alpha-value>)",
                input: "hsl(var(--input) / <alpha-value>)",
                ring: "hsl(var(--ring) / <alpha-value>)",
                background: "hsl(var(--background) / <alpha-value>)",
                foreground: "hsl(var(--foreground) / <alpha-value>)",

                light: {
                    "900": "#2a1707",
                    "775": "#403027",
                    "675": "#60483b",
                    "550": "#7d6455",
                    "450": "#997f70",
                    "325": "#b99d8d",
                    "225": "#d7bdae",
                    "100": "#f2e9e4"
                },
                tertiary: {
                    "900": "#21191d",
                    "775": "#403137",
                    "675": "#5d4850",
                    "550": "#7d626d",
                    "450": "#9d7c89",
                    "325": "#b59ca6",
                    "225": "#cebec4",
                    "100": "#e7e1e3"
                },
                grey: {
                    "900": "#0d0e0b",
                    "775": "#333432",
                    "675": "#4d4e4c",
                    "550": "#686a66",
                    "450": "#848681",
                    "325": "#a2a49f",
                    "225": "#c1c3be",
                    "100": "#e1e3de"
                },
                primary: {
                    DEFAULT: "hsl(98, 15.6%, 37.6%)",
                    foreground:
                        "hsl(var(--primary-foreground) / <alpha-value>)",
                    "900": "#191d16",
                    "775": "#2d3627",
                    "675": "#43523b",
                    "550": "#5c6f51",
                    "450": "#748c67",
                    "325": "#8fab7f",
                    "225": "#abcc98",
                    "100": "#ceebbd"
                },
                secondary: {
                    DEFAULT: "hsl(1.5, 30.7%, 50.2%)",
                    foreground:
                        "hsl(var(--secondary-foreground) / <alpha-value>)",
                    "900": "#2b1514",
                    "775": "#4f2827",
                    "675": "#743d3c",
                    "550": "#a75b59",
                    "450": "#c06c6a",
                    "325": "#cf9490",
                    "225": "#debab7",
                    "100": "#eddfde"
                },
                destructive: {
                    DEFAULT: "hsl(var(--destructive) / <alpha-value>)",
                    foreground:
                        "hsl(var(--destructive-foreground) / <alpha-value>)"
                },
                muted: {
                    DEFAULT: "hsl(var(--muted) / <alpha-value>)",
                    foreground: "hsl(var(--muted-foreground) / <alpha-value>)"
                },
                accent: {
                    DEFAULT: "hsl(12.6, 67.5%, 62.5%)",
                    foreground: "hsl(var(--accent-foreground) / <alpha-value>)",
                    "900": "#2a160f",
                    "775": "#572316",
                    "675": "#85311e",
                    "550": "#b2442b",
                    "450": "#db5a3d",
                    "325": "#e07a5f",
                    "225": "#ebb5a6",
                    "100": "#f3ded8"
                },
                popover: {
                    DEFAULT: "hsl(var(--popover) / <alpha-value>)",
                    foreground: "hsl(var(--popover-foreground) / <alpha-value>)"
                },
                card: {
                    DEFAULT: "hsl(var(--card) / <alpha-value>)",
                    foreground: "hsl(var(--card-foreground) / <alpha-value>)"
                }
            },
            borderRadius: {
                lg: "var(--radius)",
                md: "calc(var(--radius) - 2px)",
                sm: "calc(var(--radius) - 4px)"
            },
            fontFamily: {
                sans: [...fontFamily.sans]
            }
        }
    }
};

export default config;
