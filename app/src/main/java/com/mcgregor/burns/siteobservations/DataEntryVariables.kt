package com.mcgregor.burns.siteobservations

enum class Severity {
    Low, Medium, High
}

val conditions = listOf<String>("unsafe Act", "Unsafe Condition", "Near miss", "Significant Near Miss")

val contractors: List<String> = listOf<String>(
    "Akela", "Bunyand and Bell", "Dovend", "Turner Access", "Marley", "Kelvin", "Tilecraft",
    "Tclarke", "Pbr", "A Boyd", "Bricklayers", "KS Windows", "Universal", "Voltaire", "Landscape Design", "Flooring Contractor",
    "Jdr", "Energy Assets", "Apex", "Cleaner"
)

val trades = listOf<String>(
    "Bricklayer", "Cala", "Cleaner", "Demolition", "Electricity / Services",
    "Fencing", "Flooring", "General Builder", "Groundworker", "Housekeeping", "Insulation",
    "Joiner / Carpenter", "Kit / Timber Frame", "Kitchen", "Landscaper", "Lift", "Mastic",
    "Other", "Painting & Decorating", "Piling", "Plasterer / Dryliner", "Plumbing", "Roof Tiler",
    "Roofer", "Roughcastng / Render", "Scaffolding", "Site Security", "Steelworker", "Tiler",
    "Traffic management", "Utilities", "Wardrobe", "Window Fitter"
)

val issues = listOf<String>(
    "Access / Egress - Inadequate",
    "Access / Egress - Plot Access",
    "Access / Egress - Temp Stairs / Handrail",
    "Electrical - Generally Unsafe",
    "Electrical - Insufficient Testing",
    "Electrical - Unsafe System Of Work",
    "Enviromental - General",
    "Enviromental - Lack Of Dust Suppression",
    "Enviromental - No Drip Tray",
    "Enviromental - Waste Management",
    "Excavations",
    "Fire - Equipment Issues",
    "Fire - Smoking on Site",
    "General - COSHH",
    "General - Debris not being removed from work area",
    "General - Induction",
    "General - Manual Handling",
    "General - Materials Storage",
    "General - Not Signing In",
    "General - Rams",
    "General - Unsafe sequence of work",
    "General - unsafe working practice",
    "General - Weather",
    "General - Welfare Cleanliness",
    "General - Work at height",
    "General - Workplace tidiness",
    "Hand Tools - Dust Suppression",
    "Manhole / Disconnector lids not secured",
    "Permit to work - Confined spaces",
    "Permit to work - Hot works",
    "Permit to work - Overhead cables",
    "Permit to work - Permit to dig",
    "Plant - beacon not being used",
    "Plant - Key left in ignition",
    "Plant - Machine issue",
    "Plant - Operator issue",
    "Plant - Seatbelt not being worn",
    "PPE - Boots",
    "PPE - Dust mask",
    "PPE - Ear Defenders",
    "PPE - Gloves",
    "PPE - Googles",
    "PPE - Hard Hat",
    "PPE - High Vis",
    "Public Protection",
    "Scaffolding - Bombing Materials",
    "Scaffolding - Brickguards removed",
    "Scaffolding - Exceeding maximum loads",
    "Scaffolding - Handrails removed",
    "Scaffolding - harness",
    "Scaffolding - Hop ups removed",
    "Scaffolding - Poor ground conditions",
    "Scaffolding - Tidiness",
    "Scaffolding - Unsafe Adjustment",
    "Scaffolding - Unsafe working practice",
    "Traffic Management - Banking of wagons / plant",
    "Traffic Management - Lack of segregation",
    "Traffic Management - Loading and unloading",
    "Traffic Management - Public safety",
    "Traffic Management - walkways inadequate",
    "Traffic Management - Walkways not being used")

