package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class News {

    // News Element: newsPackMap
    public static Map<String, List<NewsModel>> newsPackMap = new HashMap<>();

    // Put the news into the newsPack
    static {
        newsPackMap.put("Art", new ArrayList<NewsModel>(){{
            add(new NewsModel("1","art","Hilma af Klint’s family criticises the NFT sale of the artist’s sacred paintings","The Swedish artist family say the digital drop contradicts the artist’s will and goes against her artistic intentions."));
            add(new NewsModel("2", "art","Trove of terracotta figurines discovered in ancient Chinese tomb","An archaeological team from the Datong Institute of Cultural Relics and Archaeology has unearthed a trove of well-preserved figures that provide a glimpse at life in the region 1,500 years ago"));
            add(new NewsModel("3","art","Massachusetts museum repatriates Wounded Knee Massacre artefacts to Lakota and Sioux nations","The Founders Museum, a small institution housed in a library, returned a variety of tribal objects to their rightful owners in South Dakota"));
            add(new NewsModel("4","art","Historic London foundry that made Big Ben bells could be saved from hotel development","The digital heritage preservation company Factum Foundation and conservation group Re-Form Heritage plan to buy the site and hold it in perpetuity as a working foundry"));
            add(new NewsModel("5","art","Records for rising stars and women artists power an otherwise subdued Sotheby’s New York contemporary art evening sale","The firm’s contemporary and “The Now” evening auctions totalled a combined $314.9m and notched new best prices for Barbara Kruger, Betye Saar and Elizabeth Peyton"));
            add(new NewsModel("6","art","Fake video claims German auction house will raise funds for Ukraine by selling—and then destroying—Russian art","Bolland Marotz in Bremen issued a statement this week saying it was \"outraged\" by the incident"));
        }});

        newsPackMap.put("Sport", new ArrayList<NewsModel>(){{
            add(new NewsModel("7","sport","World Cup 2022: 'Where there is Lionel Messi, there is hope for Argentina'","Argentina's vast support gathered in their thousands at Qatar's Energy City adjacent to the vast Lusail Stadium with only one man on their minds as they faced World Cup jeopardy. Lionel Messi has carried the hopes of this football-mad nation for most of his career, but there was an added layer of tension as Argentina confronted old rivals Mexico in an ear-splitting atmosphere on the stage that will host the final."));
            add(new NewsModel("8","sport","England 13-27 South Africa: Eddie Jones says defeat was 'entirely my fault'","Eddie Jones said England's defeat by South Africa was \"entirely my fault\" but believes they can have a \"really good go\" at next year's World Cup. The hosts were beaten 27-13 at Twickenham as the world champions dominated the set-piece. Head coach Jones apologised for the performance but said his players were still heading in the right direction, 10 months out from the World Cup."));
            add(new NewsModel("9","sport","World Cup 2022: Jurgen Klinsmann to speak to Carlos Queiroz after row","Jurgen Klinsmann says he wants to speak to Carlos Queiroz to \"calm things down\" after the Iran manager said the German's criticism of his team was a \"disgrace to football\". BBC pundit Klinsmann accused Iran of gamesmanship and said they \"worked the referee\" in their 2-0 win over Wales. Queiroz tweeted that the remarks \"undermine our efforts, sacrifices and skills\" and invited him to their camp."));
            add(new NewsModel("10","sport","World Cup 2022: Cristiano Ronaldo a 'total genius' for winning Portugal penalty - Fifa","Cristiano Ronaldo has been called a \"total genius\" by Fifa for the way in which he won a penalty for Portugal in their World Cup victory over Ghana. The 37-year-old converted from the spot to become the first man to score at five different Fifa World Cups. Portugal won 3-2, but the awarding of the spot-kick outraged Ghana boss Otto Addo, who said it was \"not a penalty\"."));
            add(new NewsModel("11","sport","World Cup 2022: 'Let's show the world what Wales are really about - Ashley Williams","Wales are in a weird position for the next couple of days because we are not definitely out of the World Cup yet, but we know we are really. Being realistic, we have to forget about making the last 16 because our chances are so slim. Instead, our focus should change to just leaving this World Cup on a high."));
            add(new NewsModel("12","sport","Australian PGA Championship: Open champion Cameron Smith claims victory","Open champion Cameron Smith starred in his home town of Brisbane to win the Fortinet Australian PGA Championship by three strokes. Smith, 29, held a three-shot overnight lead and finished with a three-under round of 68 to finish on 14 under and secure the title for a third time. The world number three had four birdies and one bogey in his final round."));
        }});

        newsPackMap.put("Business", new ArrayList<NewsModel>(){{
            add(new NewsModel("13","business","Discounts drive record online spending as holiday shopping season gets off to a roaring start","Consumers took advantage of heavy discounting by online retailers to start up the holiday shopping season in high gear. According to Adobe Analytics, record online spending on Thanksgiving and Black Friday drove Cyber Week — Thanksgiving through Cyber Monday — to $35 billion in total sales, itself a record and up 4% from last year. The numbers were driven by discounts across categories, with peak deals of 34% off the prices of toys, 25% off electronics like computers and TVs and 18% off apparel."));
            add(new NewsModel("14","business","Cyber Monday eclipses Black Friday again as inflation-pinched shoppers hunt for holiday deals","With deals beginning even earlier ahead of Black Friday than in years past and continuing well after Cyber Monday, consumers are no longer cramming all their gift shopping into one day. Adobe Analytics said Tuesday that consumers spent $11.3 billion on Cyber Monday, about 5.8% higher than last year’s haul. That sum is nearly 25% higher than the record $9.1 billion in online sales on Friday. “It has surpassed Black Friday as the biggest shopping day of the season,” said Patrick Brown, vice president of marketing and insights at Adobe, whose data shows Cyber Monday sales have outstripped Black Friday since at least 2014. Overall, Black Friday sales topped $8.9 billion last year, versus $10.7 billion on Cyber Monday 2021. That trend, Brown said, “shows no signs of slowing down.”"));
            add(new NewsModel("15","business","Financier Leon Black accused in lawsuit of raping woman in Jeffrey Epstein’s New York mansion","A former financier and associate of Jeffrey Epstein was sued Monday on allegations that he raped a woman in Epstein’s New York City mansion in spring 2002, according to court filings. Attorneys for Cheri Pierson, who filed the suit Monday in New York state court in Manhattan, said the “brutal attack” by Leon Black took place in a suite of the luxury townhouse that contained a massage table and was connected to a bathroom, according to court filings. Black stepped down as head of the investment firm Apollo Global Management, which he co-founded, after an independent review of his ties to Epstein last year. The review, carried out by a New York law firm, declared that Black wasn’t involved in Epstein’s criminal activities."));
            add(new NewsModel("16","business","Whole Foods' decision to pull Maine lobster sparks outcry from state's elected officials and lobster industry","A decision by Whole Foods to pause purchases of Maine lobster has sparked outcry from the state's elected officials and the lobster industry. Whole Foods' decision, which was announced this month, was prompted by changes in sustainability ratings for Maine lobster fisheries by separate third-party seafood monitoring groups: the California-based Monterey Bay Aquarium Seafood Watch and the London-based Marine Stewardship Council. Both point to a recent U.S. court decision indicating equipment used to harvest lobster off Maine may put North American right whales at risk. The whales have been listed as an endangered species since 1970, and fewer than 350 are believed to remain."));
            add(new NewsModel("17","business","‘There’s no rules. It’s crazy’: New money in NCAA recruiting leaves elite athletes ripe for exploitation","Over the summer, 16-year-old Georgia native T.A. Cunningham transferred to a powerhouse Southern California high school in pursuit of NFL dreams. His father wanted to cash in early with help from agents who boasted stars like Kansas City’s JuJu Smith-Schuster as clients. The family believed Cunningham stood to earn big in sponsorships, even before he got to college. Instead, the coveted junior recruit was benched, because of a decision from the state’s governing body for high school sports. “I was shocked,” Cunningham said. “And I think everyone involved with me was shocked, too.” The story rattled the world of college sports. It was the first incident of career-damaging fallout for a high school star since the NCAA’s decision to slash restrictions on athletes’ profiting from their fame after a Supreme Court loss in summer 2021."));
            add(new NewsModel("18","business","Kim Kardashian says she's 'disgusted and outraged' over Balenciaga ad featuring children and harness-wearing teddy bears","Kim Kardashian says she is “re-evaluating” her relationship with Balenciaga in light of the brand’s recent ad campaign that featured images of young children posing with teddy bears that appeared to be wearing BDSM-inspired accessories. “I have been quiet for the past few days, not because I haven’t been disgusted and outraged by the recent Balenciaga campaigns, but because I wanted an opportunity to speak to their team to understand for myself how this could have happened,” Kardashian, 42, wrote in her Instagram story on Sunday.“As a mother of four, I have been shaken by the disturbing images,” she continued. “The safety of children must be held with the highest regard and any attempts to normalize child abuse of any kind should have no place in our society — period.”"));
        }});

        newsPackMap.put("Science", new ArrayList<NewsModel>(){{
            add(new NewsModel("19","science","Panama enacts landmark legislation giving Nature rights","Panama is among the 25 most megadiverse countries in the world. It is home to big cats like jaguars and ocelots, 6 distinct monkey species like capuchins, myriad marine and bird life, and many kinds of sloth like the pygmy sloth, who is endangered. Its mystifying array of creatures shoulders Panama with a lot of responsibility for maintaining our planet’s biodiversity. That’s exactly how the first lady of Panama, Congressman Juan Diego Vásquez Gutiérrez, and biologist Callie Veelenturf saw it. Since 2020, Veelenturf, the Earth Law Center, Vásquez and his advisors have developed and proposed that the rights of nature to “exist, persist and regenerate” be legally recognized. In late Feb. 2022, all their work was rewarded when Panama’s President Laurentino Cortizo signed the Rights of Nature into the country’s laws. "));
            add(new NewsModel("20","science","Climate bill could slash US emissions by 40% after historic Senate vote","The US is, following decades of political rancor and fossil fuel industry obfuscation, almost certain to make its first significant attempt to tackle the climate crisis. Experts say it will help rewire the American economy and act as an important step in averting disastrous global heating. Independent analysis of the proposed legislation, known as the Inflation Reduction Act, shows it should slash America’s planet-heating emissions by about 40% by the end of the decade, compared with 2005 levels. This cut would bring the US within striking distance of a goal set by Joe Biden to cut emissions in half by 2030, a target that scientists say must be achieved by the whole world if catastrophic global heating, triggering escalating heatwaves, droughts and floods, is to be avoided."));
            add(new NewsModel("21","science","Australia to set aside at least 30% of its land mass.","SYDNEY, Oct 4 (Reuters) - Australia will set aside at least 30% of its land mass for conservation in a bid to protect plants and animals in the island continent famed for species found nowhere else in the world, Environment Minister Tanya Plibersek said on Tuesday. Australia has lost more mammal species than any other continent and has one of the worst rates of species decline among the world's richest countries, a five-yearly environmental report card released in July by the government showed. That report showed the number of species added to the list of threatened species or in a higher category of risk grew on average by 8% from the previous report in 2016.  The need for action to protect our plants, animals and ecosystems from extinction has never been greater, Plibersek said in a statement."));
            add(new NewsModel("22","science","Scientists unlocking secrets of why forests make us happy","How happy do you feel right now? The question is asked by an app on my phone, and I drag the slider to the space between “not much” and “somewhat”. I’m about to start a walk in the woods that is part of a nationwide research project to investigate how better to design the forests of the future. Volunteers are being sought to record their feelings before and after eight walks on a free app, Go Jauntly, which could reveal what kind of treescapes most benefit our wellbeing and mental health. I’m feeling frazzled after a week of delayed trains that led me to drive three-and-a-half hours to the Staffordshire village of Barton-under-Needwood, where the walk begins. Surely my mood will be lifted by a leafy walk through the National Forest, a vast woodland emerging across the Midlands. My guide is Miles Richardson, professor of nature connectedness at the University of Derby, who hopes the data he gathers from the Treefest walks will discover how the age, size and shape of trees and woodlands benefit wellbeing."));
            add(new NewsModel("23","science","UN ocean treaty is ‘once in a lifetime’ chance to protect the high seas","The world has a “once in a lifetime” chance to protect the high seas from exploitation, warned scientists and environmentalists, as negotiators meet at the UN headquarters in New York this week to hammer out a new treaty on the oceans. One scientist described the treaty, which will set out a legal framework to protect biodiversity and govern the high seas, as the most significant ocean protection agreement for four decades.“It’s extremely important it happens now,” said Prof Alex Rogers, science director of Rev Ocean, an ocean research NGO. “We’ve continued to see industrialisation of areas beyond national boundaries, including distant-water fishing and potentially deep-sea mining.”A vast portion of the ocean, 64% by surface area, lies outwith the exclusive economic zones (EEZs) that cover approximately 200 nautical miles from the shorelines of individual states. Referred to as the high seas, they host a wide array of ecosystems and species, many insufficiently studied and recorded. The increasing reach of shipping vessels, seabed mining and new activities such as “bioprospecting” of marine species have put the high seas and its biodiversity at increasing risk of exploitation."));
            add(new NewsModel("24","science","McKinsey: fundamental transformation of global economy needed for net zero.","Reaching net zero climate emissions by 2050 will require a “fundamental transformation of the global economy”, according to a report by McKinsey, one of the world’s most influential consulting firms. It estimates that $9.2tn will need to be invested every year for decades to limit the global temperature rise to 1.5C and end the climate emergency. The sum is a 60% increase on current investment levels and equivalent to half of global corporate profits. The report warns that the economic transformation will affect every country and every sector, with those most reliant on fossil-fuel-burning experiencing the most change. McKinsey, which advises many governments and large companies, also says the transition will be front-loaded with, for example, the cost of electricity rising before falling later."));
        }});

        newsPackMap.put("Technology", new ArrayList<NewsModel>(){{
            add(new NewsModel("25","technology","Twitter ends Covid misinformation policy under Musk","Twitter says it has stopped enforcing its policy on misleading information about coronavirus. According to the company's website, it stopped taking action against tweets breaching its Covid rules, on Wednesday, 23 November. Twitter had previously reported suspending more than 11,000 accounts for Covid misinformation as of September this year. BBC News has approached Twitter for comment. Its other policies on false information remain on Twitter's website, without a similar notice saying they will no longer be enforced. Under its Covid-specific policy, Twitter operated a five-strike system for accounts posting demonstrably false or misleading content that may lead to significant risk of harm - such as exposure to Covid or damage to public health systems."));
            add(new NewsModel("26","technology","Can age verification stop children seeing pornography?","The government is insisting its amendments to the Online Safety Bill will keep children safe on the internet. Powers to define legal but harmful content have been dropped - satisfying some free-speech advocates. Safety groups say it's too easy for children to access pornography online. But ministers reject criticism that the legislation has been watered down, pointing to what they say is better age verification for children. Ofcom research indicates that one in three children currently have access to adult content on social media. They simply lie about their date of birth to get round age restrictions on websites. As part of the bill, all sites that publish pornography will have to put in enhanced checks to ensure their users really are 18 or over."));
            add(new NewsModel("27","technology","Musk feuds with Apple over Twitter advertising","Elon Musk has said Apple has halted most of its advertising on Twitter and accused the company of threatening to remove the platform from its app store. The feud comes as many companies have halted spending on Twitter amid concerns about Mr Musk's content moderation plans for the site. Apple has not responded to requests for comment from the BBC. Mr Musk has said Twitter has seen a massive drop in revenue, blaming activists for pressuring advertisers. In a series of Tweets on Monday, he accused Apple of censorship and criticised its policies, including the charge it levies on purchases made on its app store. Apple has mostly stopped advertising on Twitter. Do they hate free speech in America? he said."));
            add(new NewsModel("28","technology","Facebook: Meta fined €265m by Irish Data Protection Commission","Meta, the company which owns Facebook, Instagram and WhatsApp, has been fined €265m (£228m) by the Irish Data Protection Commission (DPC). The fine is over a data breach that saw the personal details of hundreds of millions of Facebook users published online. Phone numbers and email addresses of up to 533m users appeared on an online hacking forum. The DPC launched an investigation in April 2021. Facebook said at the time that the information, some of which had already appeared online a number of years ago, was scraped, but not hacked, by malicious actors through a vulnerability in its tools prior to September 2019. Scraping uses automated software to lift public information from the internet that can then end up being distributed in online forums."));
            add(new NewsModel("29","technology","Crypto firm BlockFi files for bankruptcy after FTX collapse","The troubled crypto firm BlockFi has filed for bankruptcy in the US, as the dramatic collapse of FTX continues to reverberate across the industry. The company had already halted most activity on its platform, citing significant exposure to FTX. BlockFi said it was seeking court protection to restructure, settle its debts and recover money for investors. BlockFi had received a rescue deal from FTX earlier this year as the values of cryptocurrencies plunged. But FTX, a crypto exchange, ran into its own problems this month, as people rushed to pull money from the platform amid doubts about its finances. Former boss Sam Bankman-Fried, the so-called crypto king, resigned and the firm declared bankruptcy. The collapse has shaken faith in the crypto industry and drawn scrutiny from regulators. BlockFi, which offered loans and other financial services backed by borrowers' crypto assets, described the collapse of FTX as shocking."));
            add(new NewsModel("30","technology","Why Donald Trump isn't returning to Twitter (for now)","Donald Trump loves Twitter. In 2017, he said he wouldn't have become president without it. Twitter is a wonderful thing for me, because I get the word out… I might not be here talking to you right now as president if I didn't have an honest way of getting the word out, he said. After Twitter's new owner Elon Musk reversed Mr Trump's permanent suspension, you might have thought the former president would jump at the chance to come back. But so far, he hasn't taken up that offer. Why? Well, only Donald Trump knows the answer to that question for sure. But what we do know is he has a lot of money to lose from tweeting. The simplest explanation is the most likely - it's about money, says Josh Tucker, professor of politics at New York University (NYU). After Donald Trump was kicked off Twitter, he created his own social media platform called Truth Social - that looks an awful lot like Twitter. To understand the financial bind Donald Trump is in, you have to understand the complex nature of Truth Social's business set up."));
        }});
    }
}